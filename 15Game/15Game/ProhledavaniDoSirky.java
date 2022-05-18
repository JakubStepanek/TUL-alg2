public class ProhledavaniDoSirky<S extends State<S>> extends Finding<S> {

    public ProhledavaniDoSirky() {
        super();
    }

    @Override
    protected void vlozDoOpen(Node<S> node) {
        open.addLast(node);

    }

    @Override
    protected Node<S> vezmiZOpen() {
        return open.removeFirst();
    }
}
