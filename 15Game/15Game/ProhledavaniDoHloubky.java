public class ProhledavaniDoHloubky <S extends State<S>> extends Finding<S>{
    public ProhledavaniDoHloubky(){
        super();
    }
        @Override
        protected void vlozDoOpen(Node<S> node) {
            open.addFirst();
            
        }

        @Override
        protected Node<S> vezmiZOpen() {
            return open.removeFirst();
        }
    }
    

