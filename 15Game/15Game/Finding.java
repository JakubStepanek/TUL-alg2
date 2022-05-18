import java.util.LinkedList;
import java.util.List;

public abstract class Finding<S extends State<S>> {
    protected LinkedList open = new LinkedList<>();
    protected LinkedList close = new LinkedList<>();

    private static class Node<S> {
        S state;
        Node<S> previous;

        public Node(S state) {
            this(state, null);
        }

        public Node(S state, Node<S> previous) {
            this.state = state;
            this.previous = previous;
        }
    }

    public enum Metoda {
        DO_SIRKY, DO_HLOUBKY;
    }

    public static Finding getInstance() {
        return getInstance(Metoda.DO_SIRKY);
    }

    public static Finding getInstance(Metoda metoda) {
        if (metoda == Metoda.DO_SIRKY) {
            return new ProhledavaniDoSirky();
        } else if (metoda == Metoda.DO_HLOUBKY) {
            return new ProhledavaniDoHloubky();
        }
        throw new IllegalArgumentException("Neznamý typ metody!" + metoda);
    }

    public List<S> najdiReseni(S poc, S kon) {
        // inicializace prohledávání
        if (poc == null) {
            throw new IllegalArgumentException("Nepltaný počátečný stav");
        }
        if (kon == null) {
            throw new IllegalArgumentException("Nepltaný koncový stav");
        }
        open.clear();
        close.clear();
        // zajisti prohledávání / hledejReseni
        Node<S> node = hledejReseni(poc, kon);
        if (node == null) {
            return null;
        }
        // obnoví cestu
        LinkedList<S> cesta = new LinkedList<>();
        do {
            cesta.addFirst(node.state);
            node = node.previous;
        } while (node != null);
        return cesta;
    }

    private Node<S> hledejReseni(S poc, S kon) {
        // realizace algoritmu prohledávání
        vlozDoOpen(new Node(poc));
        while (!open.isEmpty()) {
            Node<S> akt = vezmiZOpen();
            close.add(akt);
            if (akt.state.jeStejny(kon)) {
                return akt;
            }
            List<S> nasl = akt.state.getNals();
            for (S nas : nasl) {
                if (jeVSeznamu(akt.state, open) || jeVSeznamu(akt.state, close)) {
                    continue;
                }
                vlozDoOpen(new Node(nas, akt));
            }
        }
        return null;
    }

    private boolean jeVSeznamu(S state, List<Node<S>> seznam) {
        for (Node<S> node : seznam) {
            if (node.state.jeStejny(stav))
                return true;
        }
        return false;
    }

    protected abstract void vlozDoOpen(Node<S> node);

    protected abstract Node<S> vezmiZOpen();

}