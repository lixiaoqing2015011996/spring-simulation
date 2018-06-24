/**
 *
 * Created by lxq on 2018/6/23.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * 图形界面实现类
 */
public class GUI {
    //新建一个弹簧
    private static Spring spring = new Spring();
    public static void main(String[] args) {
        //新建图形界面
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new FlowLayout(FlowLayout.RIGHT));
                frame.add(spring);
                JTextField jTextField1 = new JTextField("请输入弹力系数");
                JTextField jTextField2 = new JTextField("请输入初始位置");
                JTextField jTextField3 = new JTextField("请输入摩擦系数");
                frame.add(jTextField1);
                frame.add(jTextField2);
                frame.add(jTextField3);
                frame.add(new JButton(new AbstractAction("Start") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String str1 = jTextField1.getText().trim();
                        String str2 = jTextField2.getText().trim();
                        String str3 = jTextField3.getText().trim();
                        float springK = StringToNum.stringToNum(str1);
                        float target = StringToNum.stringToNum(str2);
                        float dampingK = StringToNum.stringToNum(str3);
                        System.out.println(springK);
                        System.out.println(target);
                        System.out.println(dampingK);
                        spring.start(springK,target,dampingK);
                    }
                }));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                spring.start();
            }
        });
    }
    private static class Spring extends JComponent {

        private static final int SIZE = 500; //界面大小
        private static final int DELAY = 1000 / 20; //延迟时间
        private final Icon icon = UIManager.getIcon("OptionPane.informationIcon"); //设置组件
        private final FloatSpring fs = new FloatSpring(42);
        private float target = 0; //弹簧初始位置初始化为0
        private final float delta = 1f / SIZE; //模拟延迟的时间
        private float elapsed = 0f; //花费的时间
        private Timer timer = new Timer(DELAY, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if ((int) fs.getPosition() < (target + 1)) {
                    timer.stop();
                    return;
                }
                target = fs.getTarget();
                elapsed += delta;
                fs.update(target, elapsed);
                repaint();
            }
        });

        //子组件的位置
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = (getWidth() - icon.getIconWidth()) / 2;
            int y = (int) fs.getPosition();
            icon.paintIcon(this, g, x, y);
            int xc = x + icon.getIconWidth() / 2;
            g.drawLine(xc, 0, xc, y);
        }
        //设置图形界面宽度和长度
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(SIZE / 2, SIZE);
        }
        //弹簧刚开始默认运动
        public void start() {
            timer.stop();
            elapsed = 0;
            fs.setPosition(SIZE - icon.getIconHeight());
            fs.setVelocity(0);
            timer.start();
        }
        //设置参数后弹簧的运动变化
        public void start(float springK,float target,float dampingK) {
            timer.stop();
            elapsed = 0;
            fs.setSpringK(springK);
            fs.setTarget(target);
            fs.setDampingK(dampingK);
            fs.setVelocity(0);
            fs.setPosition(SIZE - icon.getIconHeight());
            timer.start();
        }
    }
}
