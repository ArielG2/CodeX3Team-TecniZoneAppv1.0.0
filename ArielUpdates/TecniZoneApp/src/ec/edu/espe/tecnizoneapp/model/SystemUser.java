package ec.edu.espe.tecnizoneapp.model;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class SystemUser {
    private String username;
    private String password;
    private String userRole;

    public SystemUser(String username, String password, String userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }
    
    public boolean login(String passwordEntered) {
        if (this.password.equals(passwordEntered)) {
            System.out.println("¡Bienvenido, " + this.username + "! Inicio de sesión exitoso.");
            return true;
        } else {
            System.out.println("Error: Contraseña incorrecta.");
            return false;
        }
    }
    
    public void updatePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("La contraseña ha sido actualizada correctamente.");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    
    
}
