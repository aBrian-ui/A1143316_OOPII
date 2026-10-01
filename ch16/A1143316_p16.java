import javax.swing.*;
import java.awt.*;

public class A1143316_p16 extends JFrame {

    // 紀錄擲骰子次數
    int count = 0;

    // 紀錄骰子總和
    int sum = 0;

    public A1143316_p16() {

        // 設定視窗
        setTitle("骰子模擬器");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // 上方顯示資訊
        JLabel info = new JLabel("已擲 0 次，總和 0，平均 0.00");
        info.setBounds(50, 30, 300, 30);
        info.setHorizontalAlignment(SwingConstants.CENTER);

        // 中央顯示骰子點數
        JLabel dice = new JLabel("0");
        dice.setBounds(100, 80, 200, 80);
        dice.setFont(new Font("微軟正黑體", Font.PLAIN, 60));
        dice.setHorizontalAlignment(SwingConstants.CENTER);

        // 下方「擲骰子」按鈕
        JButton btn = new JButton("擲骰子");
        btn.setBounds(150, 200, 100, 40);

        // 按下按鈕
        btn.addActionListener(e -> {

            // 隨機產生 1~6
            int point = (int)(Math.random() * 6) + 1;

            // 次數 +1
            count++;

            // 總和增加
            sum += point;

            // 計算平均
            double average = (double)sum / count;

            // 更新骰子點數
            dice.setText(String.valueOf(point));

            // 更新上方資訊
            info.setText(String.format(
                "已擲 %d 次，總和 %d，平均 %.2f",
                count, sum, average
            ));

            // 設定骰子文字顏色
            if (point == 6) {
                dice.setForeground(Color.GREEN);
            }
            else if (point == 1) {
                dice.setForeground(Color.RED);
            }
            else {
                dice.setForeground(Color.BLACK);
            }
        });

        // 加入元件
        add(info);
        add(dice);
        add(btn);

        // 最後顯示視窗
        setVisible(true);
    }

    public static void main(String[] args) {
        new A1143316_p16();
    }
}