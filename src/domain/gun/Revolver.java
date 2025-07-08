package domain.gun;

import java.util.Random;

public class Revolver {
    private final int[] chambers = new int[6];   // 1: 총알, 0: 빈 칸
    private int pointer = 0;             // 현재 발사 위치
    private final Random rand  = new Random();

    /** 한 발만 무작위 장전, 실린더도 무작위 회전 */
    public void reload() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("[알림] : 게임 도우미가 탄창을 채우고 있습니다...");

        for (int i = 0; i < chambers.length; i++) chambers[i] = 0;
        chambers[rand.nextInt(6)] = 1;
        pointer = rand.nextInt(6);

        Thread.sleep(3000);
    }

    /** @return true: 발사(총알) / false: 불발 */
    public boolean fire(int trigger) {
        if (trigger != 1) {              // 방아쇠 미당김
            System.out.println("[알림] : 방아쇠를 당기지 않았습니다. 정확한 숫자를 입력해주세요.");
            spin();
            return false;
        }

        boolean shot = (chambers[pointer] == 1);
        if (shot) chambers[pointer] = 0; // 총알 소모
        spin();
        return shot;
    }

    /** 한 칸 회전 */
    private void spin() {
        pointer = (pointer + 1) % chambers.length;
    }
}