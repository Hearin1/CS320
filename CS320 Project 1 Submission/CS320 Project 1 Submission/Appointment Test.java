import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentTest {

    @Test
    public void testAppointmentCreation() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000); // A future date
        Appointment appointment = new Appointment("1234567890", futureDate, "Description of the appointment");
        assertEquals("1234567890", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Description of the appointment", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentCreation() {
        Date pastDate = new Date(System.currentTimeMillis() - 10000); // A past date

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, new Date(), "Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123456789012", new Date(), "Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", null, "Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", pastDate, "Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", new Date(), null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", new Date(), "This description is way too long and should not be accepted by the appointment object.");
        });
    }

    @Test
    public void testSetDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000); // A future date
        Appointment appointment = new Appointment("1234567890", futureDate, "Initial Description");
        appointment.setDescription("Updated Description");
        
        assertEquals("Updated Description", appointment.getDescription());
    }
}