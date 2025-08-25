public class Player {
    private final Decoder decoder;
    private final PlayerUI ui;
    private final FrameCache cache;

    public Player(Decoder decoder, PlayerUI ui, FrameCache cache) {
        this.decoder = decoder;
        this.ui = ui;
        this.cache = cache;
    }

    public void play(byte[] fileBytes) {
        Frame f = decoder.decode(fileBytes);
        cache.save(f);
        ui.display(f);
    }
}

public interface Decoder {
    Frame decode(byte[] fileBytes);
}

public class SimpleDecoder implements Decoder {
    @Override
    public Frame decode(byte[] fileBytes) {
        return new Frame(fileBytes);
    }
}

public interface PlayerUI {
    void display(Frame f);
}

public class ConsolePlayerUI implements PlayerUI {
    @Override
    public void display(Frame f) {
        System.out.println("\u25B6 Playing " + f.data.length + " bytes");
    }
}

public interface FrameCache {
    void save(Frame f);
    boolean hasLast();
}

public class SimpleFrameCache implements FrameCache {
    private Frame last;
    @Override
    public void save(Frame f) { last = f; }
    @Override
    public boolean hasLast() { return last != null; }
}