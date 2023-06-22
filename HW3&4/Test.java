import BusTicketSystem.*;

public class Test {
    public static void main(String[] args) {
        Bus bus = new BusType1("Bus Type 1", "123", 8, 40);
        //Bus bus = new BusType2("Bus Type 2", "456", 6, 46); // ---> to test BusType2 instead of BusType1, please add comment to line 5 and delete the comment in this line.
        Passenger p1 = new Passenger("Fatih", "Demirci", true, 1000);
        Passenger p2 = new Passenger("Fatih", "Nar", true, 1000);
        Passenger p3 = new Passenger("Elif", "Güngör", false, 100);
        Passenger p4 = new Passenger("Evren", "Aykaç", true, 1000);
        Passenger p5 = new Passenger("Çağıl Özge", "Özkul", false, 1000);
        Passenger p6 = new Passenger("Emre", "Demirbaş", true, 1000);
        Passenger p7 = new Passenger("Faruk", "Özüyağlı", true, 1000);
        Passenger p8 = new Passenger("Muhammed Abdullah", "Bülbül", true, 300);
        Passenger p9 = new Passenger("Ayşe", "Şen", false, 1000);
        Passenger p10 = new Passenger("Nefin", "Demirer", false, 1000);
        Passenger p11 = new Passenger("Ahsen", "Demir", false, 1000);
        Passenger p12 = new Passenger("Kübra", "Kip", false, 1000);
        Passenger p13 = new Passenger("Fatma", "Eliaçık", false, 1000);
        Passenger p14 = new Passenger("Damla", "Yıldız", false, 1000);
        Passenger p15 = new Passenger("Enes", "Ceylan", false, 1000);
        Passenger p16 = new Passenger("İrem", "Gül", false, 1000);
        Passenger p17 = new Passenger("Figen", "Gülhan", false, 1000);
        Passenger p18 = new Passenger("Begüm", "Doğru", false, 1000);
        Passenger p19 = new Passenger("Ayşe", "Gedik", false, 1000);
        Passenger p20 = new Passenger("İpek", "Kara", false, 1000);
        Passenger p21 = new Passenger("Sude", "Aktaş", false, 1000);
        Passenger p22 = new Passenger("Fatma", "Küçük", false, 1000);
        Passenger p23 = new Passenger("Sude", "Aydınlı", false, 1000);
        Passenger p24 = new Passenger("Yusuf Şevki", "Günaydın", true, 450);
        Passenger p25 = new Passenger("Ahmet Esad", "Top", true, 1000);
        Passenger p26 = new Passenger("Metin", "Aktaş", true, 260);
        Passenger p27 = new Passenger("Elif", "Şanlıalp", false, 250);
        Passenger p28 = new Passenger("Nisanur", "Mercimek", false, 250);
        Passenger p29 = new Passenger("Çağın", "Özkaya", true, 250);
        Passenger p30 = new Passenger("Emin Salih", "Açıkgöz", true, 300);
        Passenger p31 = new Passenger("Ömer Faruk", "Başaran", true, 250);
        Passenger p32 = new Passenger("Mehmet Emre", "Cebeci", true, 250);
        Passenger p33 = new Passenger("Ayşenur", "Akça", false, 250);
        Passenger p34 = new Passenger("Ahmet", "Şimşek", true, 300);
        Passenger p35 = new Passenger("Pelin", "Aykaç", false, 1000);
        Passenger p36 = new Passenger("İpek", "Kara", false, 1000);
        Passenger p37 = new Passenger("Sude", "Ertan", false, 1000);
        Passenger p38 = new Passenger("İlayda", "Çelik", false, 1000);
        Passenger p39 = new Passenger("Mehmet", "Yıldırım", true, 1000);
        Passenger p40 = new Passenger("Göktuğ", "Küçük", true, 1000);
        Passenger p41 = new Passenger("Merve", "Yalçın", false, 150);
        Passenger p42 = new Passenger("Behzat", "Rasuli", true, 450);
        Passenger p43 = new Passenger("Barış", "Ayhan", true, 150);
        Passenger p44 = new Passenger("Güvenç", "Şepoğlu", true, 290);
        Passenger p45 = new Passenger("Ömer Oğuz", "Özdemir", true, 346);
        Passenger p46 = new Passenger("Polat", "Kara", true, 150);
        Passenger p47 = new Passenger("Mehmet", "Bolat", true, 200);
        Passenger p48 = new Passenger("Kemal", "Yüksel", true, 345);
        Passenger p49 = new Passenger("Merve", "Kurtoğlu", false, 0);
        Passenger p50 = new Passenger("Cansu", "Say", false, 500);
        Passenger p51 = new Passenger("Erman", "Yaşar", true, 500);
        Passenger p52 = new Passenger("Alaittin", "Güneş", true, 300);
        Passenger p53 = new Passenger("İrem", "Koç", false, 460);
        Passenger p54 = new Passenger("Rabia", "Özen", false, 199);
        Passenger p55 = new Passenger("Altuğ", "Güneş", true, 250);
        Passenger p56 = new Passenger("Nezaket", "Aydın", false, 1000);
        Passenger p57 = new Passenger("Yusuf", "Yılmaz", true, 1000);
        Passenger p58 = new Passenger("Elif", "Engin", false, 1000);
        Passenger p59 = new Passenger("Ece", "Ahlatcı", false, 1000);
        Passenger p60 = new Passenger("Ezgi", "Güngör", false, 1000);


        bus.sellSeat(p1, 0.0);
        bus.sellSeat(p2, 0.0);
        System.out.println(bus);

        bus.sellSeat(p3, 0.0);
        System.out.println(bus);

        p3.deposit(100);
        bus.sellSeat(p3, 0.0);
        System.out.println(bus);


        Passenger[] passengerArray1 = new Passenger[]{p4, p5, p6, p7};
        bus.sellSeat(passengerArray1, 1.0 / 14);
        System.out.println(bus);


        bus.sellSeat(p9, 3.0 / 14);
        bus.sellSeat(p8, 3.0 / 14);
        System.out.println(bus);


        bus.sellSeat(p10, 3.0 / 14);
        System.out.println(bus);


        Passenger[] passengerArray2 = new Passenger[]{p11, p12, p13};
        bus.sellSeat(passengerArray2, 4.0 / 14);
        System.out.println(bus);


        Passenger[] passengerArray3 = new Passenger[]{p14, p15, p16, p17};
        bus.sellSeat(passengerArray3, 0.0);
        System.out.println(bus);


        Passenger[] passengerArray4 = new Passenger[]{p18, p19, p20, p21, p22};
        bus.sellSeat(passengerArray4, 0.5);
        System.out.println(bus);

        Passenger[] passengerArray5 = new Passenger[]{p23, p24, p25, p26, p27, p28};
        bus.sellSeat(passengerArray5, 1.0);
        System.out.println(bus);


        bus.sellSeat(p29, 0.0);
        bus.sellSeat(p30, 0.5);
        bus.sellSeat(p31, 1.0);
        bus.sellSeat(p32, 0.33);
        System.out.println(bus);


        Passenger[] passengerArray6 = new Passenger[]{p33, p34, p35};
        bus.sellSeat(passengerArray6, 0.5);
        System.out.println(bus);


        Passenger[] passengerArray7 = new Passenger[]{p36, p37, p38, p39, p40};
        bus.sellSeat(passengerArray7, 1.0);
        System.out.println(bus);

        // Additional Test Cases For Bus-Type 2
        /*
        bus.sellSeat(p41, 0.0);
        System.out.println(bus);

        p41.deposit(100);
        bus.sellSeat(p41, 0.25);
        System.out.println(bus);

        bus.sellSeat(p45, 0.4);
        System.out.println(bus);

        bus.sellSeat(p46, 0.6);
        System.out.println(bus);
        Passenger[] passengerArray8 = new Passenger[]{p47};
        bus.sellSeat(passengerArray8, 0.0);
        System.out.println(bus);

        Passenger[] passengerArray9 = new Passenger[]{p48, p49, p50, p51, p52, p53, p54};
        p49.deposit(200);
        bus.sellSeat(passengerArray9, 0.5);
        System.out.println(bus);

        bus.sellSeat(p56, 0.0); // p56 can't buy seat because of the same-gender rule!
        System.out.println(bus);

        bus.sellSeat(p57, 0.6);
        System.out.println(bus);
        */

        bus.sellSeat(p55, 0.5);
        System.out.println(bus);

        Passenger[] passengerArray10 = new Passenger[]{p58, p59, p60};
        bus.sellSeat(passengerArray10, 0.0);
        System.out.println(bus);

        bus.makeSeatFree(1);
        bus.makeSeatFree(2);
        bus.makeSeatFree(4);
        System.out.println(bus);

        int[] ticketNumbersOfPassangerArray10 = new int[passengerArray10.length];
        for (int i = 0; i < ticketNumbersOfPassangerArray10.length; i++) {
            ticketNumbersOfPassangerArray10[i] = passengerArray10[i].getTicketNumber();
        }
        bus.makeSeatFree(ticketNumbersOfPassangerArray10);
        System.out.println(bus);

        bus.sellSeat(p56, 0.0);
        System.out.println(bus);


        bus.makeSeatFree(p56);
        System.out.println(bus);


    }
}