import domain.gun.Revolver;
import domain.player.Player;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.*;

public class RussianRoulette {

    public static void main(String[] args) throws InterruptedException {
        initiateGame();
        gameManuel();

        initialPlayerMessage();
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < 6; i++) players.add(new Player(i));

        Revolver revolver = new Revolver();
        revolver.reload();
        reloadMessage();

        Scanner sc = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            for (Player p : players) {
                if (!p.isAlive()) continue;

                System.out.print("[알림] : " + (p.getId() +1) + "번 플레이어 차례 (1을 입력하여 방아쇠를 당겨주세요.) ▶ ");
                int input = sc.nextInt();

                resultDelay();

                if (revolver.fire(input)) {
                    p.kill();
                    killed();
                    gameOver = true;
                    break;
                }

                survive();

            }
        }
        sc.close();

    }

    private static void initiateGame() throws InterruptedException {
        System.out.println("[알림] : 러시안 룰렛 게임에 오신 것을 환영합니다.");
        System.out.println("                     ______\n" +
                "                  .-\"      \"-.\n" +
                "                 /            \\\n" +
                "                |              |\n" +
                "                |,  .-.  .-.  ,|\n" +
                "                | )(__/  \\__)( |\n" +
                "                |/     /\\     \\|\n" +
                "      (@_       (_     ^^     _)\n" +
                " _     ) \\_______\\__|IIIIII|__/__________________________\n" +
                "(_)@8@8{}<________|-\\IIIIII/-|___________________________>\n" +
                "       )_/        \\          /\n" +
                "      (@           `--------` ");
        sleep(3000);

    }

    private static void gameManuel() throws InterruptedException {
        System.out.println("[알림] : ========== 게임 방법 ==========");
        System.out.println("[알림] : 1. 현재 프로토 타입으로 게임 인원은 고정 6명입니다.");
        System.out.println("[알림] : 2. 각자 차례에 1을 입력하면 방아쇠를 당길 수 있습니다.");
        System.out.println("[알림] : =============================");
        sleep(2000);
        System.out.println("[알림] : 잠시후 게임이 시작 됩니다 ...");
    }

    private static void initialPlayerMessage() {
        System.out.println("[알림] : =============================");
        System.out.println("[알림] : 플레이어들을 생성하고 있습니다...");
        System.out.println("[알림] : =============================");
    }

    private static void reloadMessage() throws InterruptedException {
        sleep(2000);
        System.out.println("[알림] : =============================");
        System.out.println("[알림] : 러시안 룰렛을 위한 리볼버가 장전 되었습니다...");
        System.out.println("[알림] : ========== GAME START ==========");
        System.out.println("[알림] : 지금부터 게임을 시작합니다 !");

    }

    private static void resultDelay() throws InterruptedException {
        System.out.println("..3");
        sleep(1000);
        System.out.println();
        System.out.println("..2");
        sleep(1000);
        System.out.println();
        System.out.println("..1");
        sleep(1000);
    }

    private static void survive() throws InterruptedException {
        System.out.println("[알림] : 당신은 생존하였습니다.");
        System.out.println("[알림] : 실린더를 한칸 돌린 뒤 옆 사람에게 전달합니다.");
        System.out.println( "  ____________________________________/\\/\\___/ /|\n" +
                " ()___________________________________      / /|/\\\n" +
                "                       /0 0  ---- |----    /---\\\n" +
                "                       |0 o 0 ----|| - \\ --|      \\\n" +
                "                       \\0_0/____/ |    |  |\\      \\\n" +
                "                                   \\__/__/  |      \\\n" +
                "                                             |       \\\n" +
                "                                             |         \\\n" +
                "                                             |__________|");
        System.out.println("[알림] : ==========================================================");


    }

    private static void killed() {
        System.out.println(" @@@@@                                        @@@@@\n" +
                "@@@@@@@                                      @@@@@@@\n" +
                "@@@@@@@           @@@@@@@@@@@@@@@            @@@@@@@\n" +
                " @@@@@@@@       @@@@@@@@@@@@@@@@@@@        @@@@@@@@\n" +
                "     @@@@@     @@@@@@@@@@@@@@@@@@@@@     @@@@@\n" +
                "       @@@@@  @@@@@@@@@@@@@@@@@@@@@@@  @@@@@\n" +
                "         @@  @@@@@@@@@@@@@@@@@@@@@@@@@  @@\n" +
                "            @@@@@@@    @@@@@@    @@@@@@\n" +
                "            @@@@@@      @@@@      @@@@@\n" +
                "            @@@@@@      @@@@      @@@@@\n" +
                "             @@@@@@    @@@@@@    @@@@@\n" +
                "              @@@@@@@@@@@  @@@@@@@@@@\n" +
                "               @@@@@@@@@@  @@@@@@@@@\n" +
                "           @@   @@@@@@@@@@@@@@@@@   @@\n" +
                "           @@@@  @@@@ @ @ @ @ @@@@  @@@@\n" +
                "          @@@@@   @@@ @ @ @ @ @@@   @@@@@\n" +
                "        @@@@@      @@@@@@@@@@@@@      @@@@@\n" +
                "      @@@@          @@@@@@@@@@@          @@@@\n" +
                "   @@@@@              @@@@@@@              @@@@@\n" +
                "  @@@@@@@                                 @@@@@@@\n" +
                "   @@@@@                                   @@@@@");

        System.out.println("[알림] : 총알이 발사되어 당신은 사망하였습니다...");
        System.out.println("[알림] : 게임을 종료합니다.");
    }
}
