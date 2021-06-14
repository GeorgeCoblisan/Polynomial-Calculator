package test;

import DataModels.Model;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class Teste {
    private static Model model;
    private static int nrTesteExecutate = 0;
    private static int nrTesteCuSucces = 0;
    ArrayList<String> rez = new ArrayList<>();

    public Teste()
    {
        System.out.println("Constructor inaintea fiecarui test!");
    }
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("O singura data inaintea executiei setului de teste din clasa!");
        model = new Model();
    }
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("O singura data dupa terminarea executiei setului de teste din clasa!");
        System.out.println("S-au executat " + nrTesteExecutate + " teste din care "+ nrTesteCuSucces + " au avut succes!");
    }
    @Before
    public void setUp() throws Exception {
        System.out.println("Incepe un nou test!");
        nrTesteExecutate++;
    }
    @After
    public void tearDown() throws Exception {
        System.out.println("S-a terminat testul curent!");
    }

    @Test
    public void testAdunare() {
        model.reset();
        String asteptat = "6X^3+4X^2+-10X+120=0";
        String rezultat ="";
        String s1 = "3X^3+2X^2-5X+60=0";
        String[] content1 = s1.split("");
        ArrayList<String> input1 = new ArrayList<>();
        for(String c: content1)
            input1.add(c);
        String s2 = "3X^3+2X^2-5X+60=0";
        String[] content2 = s2.split("");
        ArrayList<String> input2 = new ArrayList<>();
        for(String c: content2)
            input2.add(c);
        model.adunare(input1, input2);
        rez = model.getRez();
        assertNotNull(rez);
        for(String i: rez)
            rezultat += i;
        assertEquals(rezultat, asteptat);
        nrTesteCuSucces++;
    }

    @Test
    public void testScadere() {
        model.reset();
        String asteptat = "3X^4+-2X^3+-2X^2+6X+-12=0";
        String rezultat ="";
        String s1 = "-5X^3+2X-6=0";
        String[] content1 = s1.split("");
        ArrayList<String> input1 = new ArrayList<>();
        for(String c: content1)
            input1.add(c);
        String s2 = "3X^4-3X^3-2X^2-4X+6=0";
        String[] content2 = s2.split("");
        ArrayList<String> input2 = new ArrayList<>();
        for(String c: content2)
            input2.add(c);
        model.scadere(input1, input2);
        rez = model.getRez();
        assertNotNull(rez);
        for(String i: rez)
            rezultat += i;
        assertEquals(rezultat, asteptat);
        nrTesteCuSucces++;
    }

    @Test
    public void testInmultire() {
        model.reset();
        String asteptat = "-6X^4+7X^3+-6X^2+134X+132=0";
        String rezultat ="";
        String s1 = "-2X^2+5X+6=0";
        String[] content1 = s1.split("");
        ArrayList<String> input1 = new ArrayList<>();
        for(String c: content1)
            input1.add(c);
        String s2 = "3X^2+4X+22=0";
        String[] content2 = s2.split("");
        ArrayList<String> input2 = new ArrayList<>();
        for(String c: content2)
            input2.add(c);
        model.inmultire(input1, input2);
        rez = model.getRez();
        assertNotNull(rez);
        for(String i: rez)
            rezultat += i;
        assertEquals(rezultat, asteptat);
        nrTesteCuSucces++;
    }

    @Test
    public void testImpartire() {
        model.reset();
        String asteptat = "2.5X+0.25=0 r = 1.75=0";
        String rezultat ="";
        String s1 = "5X^2+3X+2=0";
        String[] content1 = s1.split("");
        ArrayList<String> input1 = new ArrayList<>();
        for(String c: content1)
            input1.add(c);
        String s2 = "2X+1=0";
        String[] content2 = s2.split("");
        ArrayList<String> input2 = new ArrayList<>();
        for(String c: content2)
            input2.add(c);
        model.impartire(input1, input2);
        rez = model.getRez();
        assertNotNull(rez);
        for(String i: rez)
            rezultat += i;
        assertEquals(rezultat, asteptat);
        nrTesteCuSucces++;
    }

    @Test
    public void testDerivare() {
        model.reset();
        String asteptat = "6X+4=0";
        String rezultat ="";
        String s1 = "3X^2+4X+22=0";
        String[] content1 = s1.split("");
        ArrayList<String> input1 = new ArrayList<>();
        for(String c: content1)
            input1.add(c);
        model.derivare(input1);
        rez = model.getRez();
        assertNotNull(rez);
        for(String i: rez)
            rezultat += i;
        assertEquals(rezultat, asteptat);
        nrTesteCuSucces++;
    }

    @Test
    public void testIntegrala() {
        model.reset();
        String asteptat = "X^3+2.0X^2+22.0X=0";
        String rezultat ="";
        String s1 = "3X^2+4X+22=0";
        String[] content1 = s1.split("");
        ArrayList<String> input1 = new ArrayList<>();
        for(String c: content1)
            input1.add(c);
        model.integrare(input1);
        rez = model.getRez();
        assertNotNull(rez);
        for(String i: rez)
            rezultat += i;
        assertEquals(rezultat, asteptat);
        nrTesteCuSucces++;
    }
}
