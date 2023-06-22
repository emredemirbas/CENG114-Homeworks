import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");
        Solver solver = new Solver();
        for (int j = 0; j < 15; j++) {
            Random random = new Random();
            int randomLength = random.nextInt(1, 7);
            IntegerOperator[] inputs = new IntegerOperator[randomLength];
            for (int i = 0; i < inputs.length; i++) {
                inputs[i] = new IntegerOperator(random.nextInt(-100, 100));
            }
            int randomTarget = random.nextInt(-1000, 1000);
            IntegerOperator intOpTarget = new IntegerOperator(randomTarget);
            Solver integerOpSolver = new Solver();
            integerOpSolver.findSolution(inputs, intOpTarget);
            System.out.println("\n\n----------------------------------------------------------------------------------\n\n");
        }

        StringOperator A = new StringOperator("A");
        StringOperator B = new StringOperator("B");
        StringOperator C = new StringOperator("C");
        StringOperator D = new StringOperator("D");
        StringOperator E = new StringOperator("E");
        StringOperator F = new StringOperator("F");
        StringOperator G = new StringOperator("G");
        StringOperator H = new StringOperator("H");
        StringOperator I = new StringOperator("I");
        StringOperator J = new StringOperator("J");
        StringOperator K = new StringOperator("K");
        StringOperator L = new StringOperator("L");
        StringOperator M = new StringOperator("M");
        StringOperator N = new StringOperator("N");
        StringOperator O = new StringOperator("O");
        StringOperator P = new StringOperator("P");
        StringOperator Q = new StringOperator("Q");
        StringOperator R = new StringOperator("R");
        StringOperator S = new StringOperator("S");
        StringOperator T = new StringOperator("T");
        StringOperator U = new StringOperator("U");
        StringOperator V = new StringOperator("V");
        StringOperator W = new StringOperator("W");
        StringOperator X = new StringOperator("X");
        StringOperator Y = new StringOperator("Y");
        StringOperator Z = new StringOperator("Z");

        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");
        StringOperator sopTarget1 = new StringOperator("FATIH");
        StringOperator sopInputs1[] = {F, T, A, I, H};

        solver.findSolution(sopInputs1, sopTarget1);
        solver.resetSolver();

        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        StringOperator sopTarget2 = new StringOperator("NAR");
        StringOperator sopInputs2[] = {R, A, N, A};

        solver.findSolution(sopInputs2, sopTarget2);
        solver.resetSolver();

        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        StringOperator sopTarget3 = new StringOperator("EVREN");
        StringOperator sopInputs3[] = {E, V, R, N, E};

        solver.findSolution(sopInputs3, sopTarget3);
        solver.resetSolver();


        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        StringOperator sopTarget4 = new StringOperator("ALI");
        StringOperator sopInputs4[] = {L, A, I};

        solver.findSolution(sopInputs4, sopTarget4);
        solver.resetSolver();

        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        StringOperator sopTarget5 = new StringOperator("EMRE");
        StringOperator sopInputs5[] = {M, E, R, E};

        solver.findSolution(sopInputs5, sopTarget5);
        solver.resetSolver();


        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        StringOperator sopTarget6 = new StringOperator("ESAT");
        StringOperator sopInputs6[] = {T, A, S, E};

        solver.findSolution(sopInputs6, sopTarget6);
        solver.resetSolver();

        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        StringOperator sopTarget7 = new StringOperator("OMER");
        StringOperator sopInputs7[] = {M, O, R, E};


        solver.findSolution(sopInputs7, sopTarget7);
        solver.resetSolver();

        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        StringOperator sopTarget8 = new StringOperator("MEMET");
        StringOperator sopInputs8[] = {M, H, T, E};


        solver.findSolution(sopInputs8, sopTarget8);
        solver.resetSolver();

        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");


        StringOperator sopTarget9 = new StringOperator("CAGIN");
        StringOperator sopInputs9[] = {G, G, A, I, N, C};

        solver.findSolution(sopInputs9, sopTarget9);
        solver.resetSolver();

        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        StringOperator sopTarget10 = new StringOperator("AYBU");
        StringOperator sopInputs10[] = {Y, B, A, U};

        solver.findSolution(sopInputs10, sopTarget10);
        solver.resetSolver();

        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        StringOperator sopTarget11 = new StringOperator("BANANA");
        StringOperator sopInputs11[] = {A, B, N, N};

        solver.findSolution(sopInputs11, sopTarget11);
        solver.resetSolver();

        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        StringOperator sopTarget12 = new StringOperator("ELLE");
        StringOperator sopInputs12[] = {E, L, L};

        solver.findSolution(sopInputs12, sopTarget12);
        solver.resetSolver();

        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        StringOperator sop1 = new StringOperator("AYNA");
        StringOperator sopTarget13 = new StringOperator("KAYNAK");
        StringOperator sopInputs13[] = {K, K, sop1};

        solver.findSolution(sopInputs13, sopTarget13);
        solver.resetSolver();

        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        StringOperator sop2 = new StringOperator("YE");
        StringOperator sopTarget14 = new StringOperator("SANDALYE");
        StringOperator sopInputs14[] = {S, A, N, D, L, sop2};

        solver.findSolution(sopInputs14, sopTarget14);
        solver.resetSolver();

        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        Operator sopTarget15 = new StringOperator("LENOVO");
        Operator sopInputs15[] = {L, E, N, O, V};

        solver.findSolution(sopInputs15, sopTarget15);
        solver.resetSolver();

        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        StringOperator sopTarget16 = new StringOperator("FATIH");
        Operator sopInputs16[] = {F, T, H, I, A};
        solver.findSolution(sopInputs16, sopTarget16);
        solver.resetSolver();

        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        StringOperator sopTarget17 = new StringOperator("DEMIRCI");
        Operator sopInputs17[] = {D, E, M, C, R, I, I};
        solver.findSolution(sopInputs17, sopTarget17);
        solver.resetSolver();

        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        ColorOperator red = new ColorOperator(Color.Red);
        ColorOperator green = new ColorOperator(Color.Green);
        ColorOperator blue = new ColorOperator(Color.Blue);
        ColorOperator magenta = new ColorOperator(Color.Magenta);
        ColorOperator yellow = new ColorOperator(Color.Yellow);
        ColorOperator cyan = new ColorOperator(Color.Cyan);
        ColorOperator white = new ColorOperator(Color.White);
        ColorOperator black = new ColorOperator(Color.Black);

        Operator[] colorInputs1 = new ColorOperator[]{red, green};
        solver.findSolution(colorInputs1, yellow);
        solver.resetSolver();
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        Operator[] colorInputs2 = new ColorOperator[]{red, green, blue};
        solver.findSolution(colorInputs2, white);
        solver.resetSolver();
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        Operator[] colorInputs3 = new ColorOperator[]{magenta, red};
        solver.findSolution(colorInputs3, blue);
        solver.resetSolver();
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        Operator[] colorInputs4 = new ColorOperator[]{red, black};
        solver.findSolution(colorInputs4, blue);
        solver.resetSolver();
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        Operator[] colorInputs5 = new ColorOperator[]{magenta, yellow};
        solver.findSolution(colorInputs5, red);
        solver.resetSolver();
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        Operator[] colorInputs6 = new ColorOperator[]{white, magenta, yellow};
        solver.findSolution(colorInputs6, black);
        solver.resetSolver();
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        Operator[] colorInputs7 = new ColorOperator[]{green, magenta, blue};
        solver.findSolution(colorInputs7, black);
        solver.resetSolver();
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        Operator[] colorInputs8 = new ColorOperator[]{black, magenta};
        solver.findSolution(colorInputs8, white);
        solver.resetSolver();
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        Operator[] colorInputs9 = new ColorOperator[]{red, magenta, blue};
        solver.findSolution(colorInputs9, white);
        solver.resetSolver();
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        Operator[] colorInputs10 = new ColorOperator[]{red, magenta, blue, black};
        solver.findSolution(colorInputs10, green);
        solver.resetSolver();
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        Operator[] colorInputs11 = new ColorOperator[]{blue, magenta, cyan, white};
        solver.findSolution(colorInputs11, blue);
        solver.resetSolver();
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        Operator[] colorInputs12 = new ColorOperator[]{blue, white, blue, green};
        solver.findSolution(colorInputs12, magenta);
        solver.resetSolver();
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        Operator[] colorInputs13 = new ColorOperator[]{black, blue, magenta, cyan, red};
        solver.findSolution(colorInputs13, red);
        solver.resetSolver();
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        Operator[] colorInputs14 = new ColorOperator[]{green, blue, yellow, white};
        solver.findSolution(colorInputs14, blue);
        solver.resetSolver();
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        Operator[] colorInputs15 = new ColorOperator[]{red, green, blue, magenta, yellow, cyan, white, black};
        solver.findSolution(colorInputs15, white);
        solver.resetSolver();
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");

        Operator newColor = new ColorOperator(new int[]{1, 0, 2});
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");


        Operator newColor1 = new ColorOperator(5, 12, 13);
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");


        Operator o1 = new StringOperator("ABC");
        Operator o2 = new ColorOperator(Color.Black);
        Operator o3 = new IntegerOperator(5);
        Operator t = new IntegerOperator(5);
        Operator[] mixedInputs = new Operator[]{o1, o2, o3};
        solver.findSolution(mixedInputs, t);
        solver.resetSolver();
        System.out.println("\n\n----------------------------------------------------------------------------------\n\n");


        Operator[] mixedInputs2 = new Operator[]{o1, o2};
        solver.findSolution(mixedInputs2, t);
        solver.resetSolver();


    }
}