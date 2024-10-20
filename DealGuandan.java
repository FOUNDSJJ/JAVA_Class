import java.util.Scanner;
import java.util.Arrays;

public class DealGuandan {

    //指定牌点和花色
    public static String[] pokerNums = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "Little", "Big"};
    public static String[] pokerColors = {"♠", "❤", "♣", "♦", "Joker"};

    //牌型类
    public static class PokerCard implements Comparable<PokerCard> {
        private String num = "";   //牌点
        private int numIndex = -1;
        private String color = ""; //花色
        private int colorIndex = -1;

        public String getNum() {
            return num;
        }

        public int getNumIndex() {
            return numIndex;
        }

        public String getColor() {
            return color;
        }

        public int getColorIndex() {
            return colorIndex;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public void setNumIndex(int numIndex) {
            this.numIndex = numIndex;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setColorIndex(int colorIndex) {
            this.colorIndex = colorIndex;
        }

        public PokerCard(String num, int numIndex, String color, int colorIndex) {
            this.num = num;
            this.numIndex = numIndex;
            this.color = color;
            this.colorIndex = colorIndex;
        }

        public int compareTo(PokerCard other) {
            return numIndex * 4 + colorIndex - (other.getNumIndex() * 4 + other.getColorIndex());
        }

    }

    //创建初始牌堆 cardNums：牌的副数 myCard：牌堆数组
    public static void createPokerCards(int cardNums, PokerCard[] myCard) {
        for (int i = 0; i < 13 * cardNums; i++) {
            for (int m = 0; m < 4; m++)
                myCard[4 * i + m] = new PokerCard(pokerNums[i % 13], i % 13, pokerColors[m % 4], m % 4);
        }
        for (int i = 0; i < cardNums; i++) {
            for (int m = 0; m < 2; m++)
                myCard[2 * i + m + 52 * cardNums] = new PokerCard(pokerNums[i % 2 + 13], i % 2 + 13,
                        pokerColors[4], 4);
        }
    }

    //交换card1和card2
    public static void exchangeCard(PokerCard card1, PokerCard card2) {
        if (card1 == null || card2 == null) return;
        String tempNum = card1.getNum();
        String tempColor = card1.getColor();
        int tempNumIndex = card1.getNumIndex();
        int tempColorIndex = card1.getColorIndex();
        card1.setNum(card2.getNum());
        card1.setColor(card2.getColor());
        card1.setNumIndex(card2.getNumIndex());
        card1.setColorIndex(card2.getColorIndex());
        card2.setNum(tempNum);
        card2.setColor(tempColor);
        card2.setNumIndex(tempNumIndex);
        card2.setColorIndex(tempColorIndex);
    }

    //通过产生任意数洗牌 cardNums：牌的副数 myCard：牌堆数组
    public static void shuffleCards(int cardNums, PokerCard[] myCard) {
        for (PokerCard card : myCard) {
            int index = (int) (Math.random() * (54 * cardNums));
            exchangeCard(myCard[index], card);
        }
    }

    //从开始玩家发牌 myCard：牌堆数组 startPlayers：开始玩家的编号 playerCards:玩家的手牌堆 handCards：底牌堆
    public static void dealCards(PokerCard[] myCard, int startPlayer, PokerCard[][] playerCards, PokerCard[] handCards) {
        for (int start = startPlayer - 1; start < startPlayer + 3; start++) {
            playerCards[start % 4] = new PokerCard[25];
            for (int i = (start - startPlayer + 1); i < myCard.length - 8; i += 4)
                playerCards[start % 4][i / 4] = new PokerCard(myCard[i].getNum(), myCard[i].getNumIndex(),
                        myCard[i].getColor(), myCard[i].getColorIndex());
        }
        for (int i = 0; i < 8; i++) {
            handCards[i] = new PokerCard(myCard[i + myCard.length - 8].getNum(), myCard[i + myCard.length - 8].getNumIndex(),
                    myCard[i + myCard.length - 8].getColor(), myCard[i + myCard.length - 8].getColorIndex());
        }
    }

    //按顺序展示牌堆
    public static void showPokerCards(PokerCard[] myCard) {
        int i = -1;
        for (PokerCard card : myCard) {
            if (i % 32 == 31) System.out.println();
            System.out.print(card.getColor() + card.getNum() + " ");
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("请指定发牌开始人（1 2 3 4）： ");
        int startPlayer = myScanner.nextInt();         //获取发牌玩家的编号
        PokerCard[] myCard = new PokerCard[108];
        createPokerCards(2, myCard);         //创建牌堆
        System.out.println("洗牌前牌序为 ： ");
        showPokerCards(myCard);
        System.out.println("洗牌后牌序为 ： ");
        shuffleCards(2, myCard);             //洗牌
        showPokerCards(myCard);
        PokerCard[][] playerCards = new PokerCard[4][25];
        PokerCard[] handCards = new PokerCard[8];
        dealCards(myCard, startPlayer, playerCards, handCards);               //发牌 将玩家的牌存放在
        for (int i = 0; i < 4; i++) {
            System.out.print("第" + (i + 1) + "个玩家的牌序为：");
            Arrays.sort(playerCards[i]);            //排序
            showPokerCards(playerCards[i]);
        }
        System.out.print("底牌的牌序为：");
        Arrays.sort(handCards);            //排序
        showPokerCards(handCards);
    }
}
