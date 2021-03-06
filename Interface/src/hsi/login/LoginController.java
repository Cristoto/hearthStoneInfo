package hsi.login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import hsi.controlErrores.ControllerControlesView;
import hsi.menu.MenuController;
import hsi.register.RegisterController;
import hsi.sql.FuncionesSQL;
import hsi.ventanaArranque.VentanaArranqueController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Clase encargada del funcionamiento de la ventana del login.
 * 
 * @author Cristo
 *
 */
public class LoginController implements Initializable {

	// Model
	private MenuController menuController;
	private StringProperty usuario;
	private StringProperty password;

	// View
	@FXML
	private GridPane view;

	@FXML
	private TextField usuarioTextField;

	@FXML
	private PasswordField contraPassField;

	@FXML
	private Button entrarButton;

	@FXML
	private Hyperlink crearLink;

	public LoginController() throws IOException {
		usuario = new SimpleStringProperty(this, "usuario");
		password = new SimpleStringProperty(this, "password");

		menuController = new MenuController();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Bindeo
		usuario.bind(usuarioTextField.textProperty());
		password.bind(contraPassField.textProperty());
		menuController.getUsuario().bind(usuario);

		entrarButton.disableProperty().bind(usuario.isEqualTo("").or(password.isEqualTo("")));

		// Evento
		crearLink.setOnAction(e -> onCrearCuentaLinkAction(e));
		entrarButton.setOnAction(e -> onEntrarButtonAction(e));

	}

	/**
	 * Evento vinculado al bot�n Crear.
	 * Sustituye la ventana del login por la del registro de usuario.
	 * @param e
	 */
	private void onCrearCuentaLinkAction(ActionEvent e) {
		try {
			RegisterController registerController = new RegisterController();
			VentanaArranqueController.getCopiaView().setCenter(registerController.getView());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	/**
	 * Evento vinculado al bot�n Entrar.
	 * Comprueba los datos de la base de datos. Si todo es correcto cambia a la ventana de MenuController, si falla lanza una ventana de error.
	 * @param e
	 */
	private void onEntrarButtonAction(ActionEvent e) {
		Task<Boolean> task = new Task<Boolean>() {
			@Override
			protected Boolean call() throws Exception {
				return FuncionesSQL.consultaInicioSesion(usuario.get(), password.get());
			}
		};
		
		task.setOnFailed(e1 -> consultaInicioSesionTaskError(e1));
		task.setOnSucceeded(e1 ->consultaInicioSesionTaskCorrecto(e1) );
		new Thread(task).start();
	}

	private void consultaInicioSesionTaskCorrecto(WorkerStateEvent e1) {
		Boolean result = (Boolean) e1.getSource().getValue();
		if(result)
			menuController.crearMenu();
		else {
			try {
				new ControllerControlesView("Los datos no son correctos.", "..\\..\\..\\resources\\img\\hearthStoneLogo.png").crearVentana();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void consultaInicioSesionTaskError(WorkerStateEvent e1) {
		try {
			new ControllerControlesView("No se pudo conectarse con la base de datos.", "..\\..\\..\\resources\\img\\hearthStoneLogo.png").crearVentana();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public GridPane getView() {
		return view;
	}

}
