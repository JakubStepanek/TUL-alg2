import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hra8Stav implements State<Hra8Stav> {
    private int[][] pole = new int[3][3];
    private int rozmer = 3;
    private int ra, sl;

    public Hra8Stav() {
        int cislo = 1;
        for (int i = 0; i < rozmer; i++) {
            for (int j = 0; j < rozmer; j++) {
                pole[i][j] = cislo;
                cislo++;
            }
        }
        pole[rozmer - 1][rozmer - 1] = 0;
        ra = rozmer - 1;
        sl = rozmer - 1;
    }

    public Hra8Stav(int[][] pole) {
        for (int i = 0; i < rozmer; i++) {
            for (int j = 0; j < rozmer; j++) {
                pole[i][j] = pole[i][j];
                if (this.pole[i][j] == 0) {
                    ra = i;
                    sl = j;
                }
            }
        }
    }

    @Override
    public List<Hra8Stav> getNasl() {
        ArrayList<> nasl = new ArrayList<>();
        if (ra > 0) {
            // posun kamene dolu
            Hra8Stav st = new Hra8Stav(pole);
            st.pole[ra][sl] = st.pole[ra - 1][sl];
            st.pole[ra - 1][sl] = 0;
            st.ra = ra - 1;
        }
        if (ra < rozmer - 1) {
            // posun kamene nahoru
            Hra8Stav st = new Hra8Stav(pole);
            st.pole[ra][sl] = st.pole[ra + 1][sl];
            st.pole[ra + 1][sl] = 0;
            st.ra = ra + 1;
        }
        if (sl > 0) {
            // posun kamene doprava
            Hra8Stav st = new Hra8Stav(pole);
            st.pole[ra][sl] = st.pole[ra][sl - 1];
            st.pole[ra][sl - 1] = 0;
            st.sl = sl - 1;
        }
        if (sl < rozmer) {
            // posun kamene doleva
            Hra8Stav st = new Hra8Stav(pole);
            st.pole[ra][sl] = st.pole[ra][sl + 1];
            st.pole[ra][sl + 1] = 0;
            st.sl = sl + 1;
        }
        return nasl;
    }

    @Override
    public boolean jeStejny(Hra8Stav stav) {
        return Arrays.deepEquals(pole, stav.pole);
    }

    public static void main(String[] args) {
        int[][] a = {
                { 1, 2, 3 },
                { 4, 0, 5 },
                { 6, 7, 8 } };
        Hra8Stav st = new Hra8Stav();
        List<Hra8Stav> nasl = st.getNasl();
        for (Hra8Stav hra8Stav : nasl) {
            System.out.println(Arrays.toString(st.pole));
        }
    }

}
