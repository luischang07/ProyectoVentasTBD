import java.sql.SQLException;

import raven.toast.Notifications;

public class ErrorHandler {

    public static void handleSqlException(SQLException e) {
        // Examinar el código de error SQL
        int errorCode = e.getErrorCode();

        // Personalizar mensajes de error según el código de error SQL
        switch (errorCode) {
            case 201:
                // Violación de restricción de clave foránea (FK)
                showNotification("Error: Violación de restricción de clave foránea. FamId");
                break;
            case 8115:
                // El campo exede el limite de caracteres numerico
                showNotification("Error: El campo exede el limite de caracteres numerico.");
                break;
            case 2628:
                // Excedió el límite de caracteres permitido
                showNotification("Error: El campo excede el límite de caracteres permitido.");
                break;
            case 195:
                // Error específico cuando está en modo modificar y la PK no es reconocida
                showNotification("Error: El tipo de datos JDBC no es válido.");
                break;
            // Agregar más casos según sea necesario
            default:
                // Otro error SQL no manejado específicamente
                handleGenericSqlError(e);
                break;
        }
    }

    private static void handleGenericSqlError(SQLException e) {
        String errorMessage = "Error SQL no manejado específicamente: " + e.getMessage();
        showNotification(errorMessage);
    }

    public static void showNotification(String message) {
        // Aquí puedes personalizar cómo deseas mostrar la notificación
        // Puedes utilizar tu método Notifications.getInstance().show()
        // Aquí se muestra simplemente como un ejemplo
        System.out.println("Mostrar notificación de error en el centro: " + message);
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, message);
    }
}
