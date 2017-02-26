import java.util.EventListener;

public interface SearchListener extends EventListener {
    public void searchEventOccured(SearchEvent event);
}
