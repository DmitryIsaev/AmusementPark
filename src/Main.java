import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        List<Person> klients = generateClients();
        Queue<Person> attraction = new LinkedList<>(klients);
        useTicket(attraction);
    }

    private static void useTicket(Queue<Person> attraction) {
        while (!attraction.isEmpty()) {
            Person person = attraction.poll();
            int tickets = person.getTickets();
            tickets = tickets - 1;
            person.setTickets(tickets);
            System.out.println("Поститель " + person.getName() + " " + person.getSurname()
                    + " побывал(а) в парке аттракционов. Осталось билетов: " + person.getTickets());
            if (tickets > 0) {
                attraction.offer(person);
            }
        }
    }

    private static List<Person> generateClients() {
        return List.of(
                new Person("Полина", "Белова", 10),
                new Person("Егор", "Покровский", 7),
                new Person("Александра", "Абрамова", 5),
                new Person("Андрей", "Ермаков", 3),
                new Person("Варвара", "Игнатьева", 2)
        );
    }
}
