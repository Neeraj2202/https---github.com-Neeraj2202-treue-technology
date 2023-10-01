package Recommendation;

import java.util.*;


class Appointment {
    private String serviceProvider;
    private Date date;
    private String user;

    public Appointment(String serviceProvider, Date date, String user) {
        this.serviceProvider = serviceProvider;
        this.date = date;
        this.user = user;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public Date getDate() {
        return date;
    }

    public String getUser() {
        return user;
    }
}

class AppointmentScheduler {
    private Map<String, List<Date>> availability;
    private List<Appointment> appointments;

    public AppointmentScheduler() {
        availability = new HashMap<>();
        appointments = new ArrayList<>();
    }

    public void addServiceProvider(String serviceProvider, List<Date> availableDates) {
        availability.put(serviceProvider, availableDates);
    }

    public void bookAppointment(String serviceProvider, Date selectedDate, String user) {
        if (availability.containsKey(serviceProvider) && availability.get(serviceProvider).contains(selectedDate)) {
            Appointment appointment = new Appointment(serviceProvider, selectedDate, user);
            appointments.add(appointment);
            availability.get(serviceProvider).remove(selectedDate);
            System.out.println("Appointment booked successfully!");
        } else {
            System.out.println("Appointment slot not available.");
        }
    }

    public List<Appointment> getAppointmentsForUser(String user) {
        List<Appointment> userAppointments = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getUser().equals(user)) {
                userAppointments.add(appointment);
            }
        }
        return userAppointments;
    }
}

public class appointmentTrack {
    public static void main(String[] args) {
        AppointmentScheduler scheduler = new AppointmentScheduler();

        // Add service providers and their available dates
        scheduler.addServiceProvider("Provider 1", Arrays.asList(new Date(), new Date()));
        scheduler.addServiceProvider("Provider 2", Arrays.asList(new Date(), new Date(), new Date()));

        // User registration (not shown in this simplified example)

        // Book appointments
        scheduler.bookAppointment("Provider 1", new Date(), "User A");
        scheduler.bookAppointment("Provider 2", new Date(), "User B");

        // Get user appointments
        List<Appointment> userAppointments = scheduler.getAppointmentsForUser("User A");
        for (Appointment appointment : userAppointments) {
            System.out.println("User A's Appointment with " + appointment.getServiceProvider() + " on " + appointment.getDate());
        }
    }
}
