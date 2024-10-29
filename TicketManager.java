import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TicketManager {
    private static TicketManager instance;
    private Map<String, Ticket> orders;
    private TicketManager() {
        orders = new ConcurrentHashMap<>();
    }
    public static TicketManager getInstance() {
        if(instance == null) {
            instance = new TicketManager();
        }
        return instance;
    }
    public void addOrder(Ticket ticket) {
        orders.put(ticket.getId(), ticket);
    }
    public Ticket getTicket(String id) {
        return orders.get(id);
    }
}
