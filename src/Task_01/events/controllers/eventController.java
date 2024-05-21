package Task_01.events.controllers;

import Task_01.events.domains.Event;
import Task_01.events.services.EventService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class eventController {

    private final Scanner scanner;

    private final EventService eventService;

    public eventController(Scanner scanner, EventService eventService) {
        this.scanner = scanner;
        this.eventService = eventService;
    }

    public void addEvent() {

        System.out.println("Введите название мероприятия");
        String name = scanner.nextLine();

        System.out.println("Введите дату начала через \"-\" пример: (01-05-2003)");
        String startDateString = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(startDateString, DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("Введите дату конца через \"-\" пример: (01-05-2003)");
        String expirationDateString = scanner.nextLine();
        LocalDate expirationDate = LocalDate.parse(expirationDateString, DateTimeFormatter.ISO_LOCAL_DATE);

        Event event = eventService.addEvent(name, startDate, expirationDate);

        System.out.println(event);
    }

    public void getAllUsers() {
        List<Event> users = eventService.events();

        System.out.println(users);
    }
}
