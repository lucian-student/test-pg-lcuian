/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucian
 */
public class TovarnaNaJidlo {

    public static Jidlo vyrobJidlo(String jmenoJidla) {
        if (jmenoJidla.equals("dort")) {
            return new DortPejskaAKocicky();
        } else if (jmenoJidla.equals("caj")) {
            return new Caj();
        } else if (jmenoJidla.equals("svickova")) {
            return new Svickova();
        } else {

            throw new IllegalArgumentException("Nezname jidlo.");
        }
    }
}
