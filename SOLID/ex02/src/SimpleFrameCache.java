public class SimpleFrameCache implements FrameCache {
    private Frame last;
    @Override
    public void save(Frame f) { last = f; }
    @Override
    public boolean hasLast() { return last != null; }
}
