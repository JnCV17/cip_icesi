package co.com.novatech.smc.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

import co.com.novatech.smc.delegate.IBusinessDelegate;
import co.com.novatech.smc.modelo.AsSrc;
import co.com.novatech.smc.modelo.EvideFile;
import co.com.novatech.smc.modelo.PlanSmc;
import co.com.novatech.smc.modelo.UserCip;
import co.com.novatech.smc.util.FacesUtils;
import co.com.novatech.smc.util.SessionUtil;

@ManagedBean(name = "MostrarEvidenciasController")
@SessionScoped
public class MostrarEvidenciasController {

	@EJB
	private IBusinessDelegate businessDelegate;

	// atributos
	private UserCip userSesion;
	private AsSrc fuenteAssessment;
	private EvideFile evidencia;
	private DefaultStreamedContent filedownload;
	private PlanSmc planDeAssessment;

	private String descripcion = "Add description";
	private int veces = 1;

	private List<EvideFile> listaEvidenciasFuenteAssessment;

	public MostrarEvidenciasController() {
		Locale idioma = (Locale) FacesUtils.getfromSession("idioma");
		if (idioma == null) {
			idioma = new Locale("es");
		}
		FacesContext.getCurrentInstance().getViewRoot().setLocale(idioma);
	}

	public EvideFile getEvidencia() {
		return evidencia;
	}

	public AsSrc getFuenteAssessment() {
		return fuenteAssessment;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public DefaultStreamedContent getFiledownload() {

		try {

			EvideFile evidenciaDownload = businessDelegate.findByIdEvideFile(evidencia.getIdFile());

			String nameFile = evidenciaDownload.getName();

			byte[] arch = evidenciaDownload.getFileRaw();
			InputStream is = new ByteArrayInputStream(arch);

			String extension = getExtension(nameFile);

			DefaultStreamedContent nuevo = new DefaultStreamedContent(is, extension, nameFile);

			filedownload = nuevo;
		} catch (Exception e) {
			FacesUtils.addErrorMessage("", e.getMessage());
		}

		return filedownload;
	}

	public List<EvideFile> getListaEvidenciasFuenteAssessment() {
		return listaEvidenciasFuenteAssessment;
	}

	public void setListaEvidenciasFuenteAssessment(List<EvideFile> listaEvidenciasFuenteAssessment) {
		this.listaEvidenciasFuenteAssessment = listaEvidenciasFuenteAssessment;
	}

	public void setFuenteAssessment(AsSrc fuenteAssessment) {
		this.fuenteAssessment = fuenteAssessment;
	}

	public void setEvidencia(EvideFile evidencia) {
		this.evidencia = evidencia;
	}

	public void setFiledownload(DefaultStreamedContent filedownload) {
		this.filedownload = filedownload;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public PlanSmc getPlanDeAssessment() {

		planDeAssessment = (PlanSmc) SessionUtil.getFromSession("plan");
		return planDeAssessment;
	}

	public void setPlanDeAssessment(PlanSmc planDeAssessment) {
		this.planDeAssessment = planDeAssessment;
	}

	// metodos
	public void cargarFuente() {

		List<EvideFile> listaArchivos = businessDelegate.getEvideFileFindByAsSrc(fuenteAssessment.getIdAsSrc());

		listaEvidenciasFuenteAssessment = listaArchivos;

		userSesion = (UserCip) SessionUtil.getFromSession("usuarioSesion");
	}

	public UserCip getUsuarioSesion() {
		userSesion = (UserCip) FacesUtils.getfromSession("usuarioSesion");
		return userSesion;
	}

	public void uploadEvideFile(FileUploadEvent event) {
		UploadedFile file = event.getFile();

		try {

			BigDecimal numero = fuenteAssessment.getUserCipIdUser();
			long idUsuarioEncargado = numero.longValue();

			planDeAssessment = getPlanDeAssessment();
			businessDelegate.validarCargaEvidencia(planDeAssessment.getIdPlan());
			if (businessDelegate.validarUsuarioCargaEvidencia(getUsuarioSesion().getIdUser(), idUsuarioEncargado)) {

				if (file != null) {

					byte[] arch = file.getContents();

					EvideFile evidencia = new EvideFile();
					evidencia.setAsSrc(fuenteAssessment);
					evidencia.setDescription(descripcion);
					evidencia.setFileRaw(arch);
					Date fecha = new Date();
					evidencia.setLoadDate(fecha);
					evidencia.setName(file.getFileName());
					evidencia.setUserCip(userSesion);

					businessDelegate.saveEvideFile(evidencia);
					FacesUtils.addInfoMessage("File loaded successfully");
				}
			} else {
				FacesUtils.addErrorMessage("You do not have the permissions to perform this action");
			}

		} catch (Exception e) {

			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		cargarFuente();
	}

	public void eliminarEvidencia() {

		try {
			planDeAssessment = getPlanDeAssessment();
			businessDelegate.validarCargaEvidencia(planDeAssessment.getIdPlan());

			businessDelegate.deleteEvideFile(evidencia);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		cargarFuente();
	}

	public void mostrarListaEvidencias() {
		cargarFuente();
		Map<String, Object> options = new HashMap<String, Object>();

		options.put("modal", true);
		options.put("width", 800);
		options.put("height", 600);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "customheader");

		RequestContext.getCurrentInstance().openDialog("mostrarEvidencias", options, null);

	}

	private String getExtension(String name) {

		StringBuilder builder = new StringBuilder(name);
		String sCadenaInvertida = builder.reverse().toString();
		String extension = "";

		for (int i = 0; i < sCadenaInvertida.length(); i++) {

			if (sCadenaInvertida.charAt(i) != '.') {
				extension += sCadenaInvertida.charAt(i);
			} else {
				break;
			}

		}

		StringBuilder builder2 = new StringBuilder(extension);
		String sCadenaInvertida2 = builder2.reverse().toString();

		return sCadenaInvertida2;
	}

}
