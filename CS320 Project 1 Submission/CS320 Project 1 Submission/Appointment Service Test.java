import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentServiceTest {

    private AppointmentService appointmentService;

    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    public void testAddAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000); // A future date
        Appointment appointment = new Appointment("1234567890", futureDate, "Description of the appointment");
        appointmentService.addAppointment(appointment);
        assertEquals(appointment, appointmentService.getAppointment("1234567890"));
    }

    @Test
    public void testAddAppointmentWithDuplicateId() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000); // A future date
        Appointment appointment1 = new Appointment("1234567890", futureDate, "Description of the appointment 1");
        Appointment appointment2 = new Appointment("1234567890", futureDate, "Description of the appointment 2");
        appointmentService.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });
    }

    @Test
    public void testDeleteAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000); // A future date
        Appointment appointment = new Appointment("1234567890", futureDate, "Description of the appointment");
        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment("1234567890");
        assertNull(appointmentService.getAppointment("1234567890"));
    }

    @Test
    public void testDeleteAppointmentWithInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("nonexistent");
        });
    }
}