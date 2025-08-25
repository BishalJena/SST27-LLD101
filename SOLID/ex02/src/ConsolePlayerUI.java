public class ConsolePlayerUI implements PlayerUI {
    @Override
    public void display(Frame f) {
        System.out.println("\u25B6 Playing " + f.data.length + " bytes");
    }
}
