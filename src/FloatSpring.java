/**
 *
 * Created by lxq on 2018/6/23.
 */

/**
 * 弹簧类
 */
public class FloatSpring {

    //浮动位置
    float position;

    //弹簧常数
    float springK;

    //阻尼常数
    float dampingK;

    //浮动速度
    float velocity;

    //弹簧起始位置
    float target;

    /**
     * 用给定的弹簧常数和阻尼常数来制作弹簧
     *
     * @param springK
     *          弹簧常数,这个越高，弹簧越“紧密”，并且
     *          给定扩展将施加的力越大
     * @param dampingK
     *          阻尼常数, 这个越高，弹簧弹的速度越慢
     */
    public FloatSpring(float springK, float dampingK) {
        super();
        this.position = 0;
        this.springK = springK;
        this.dampingK = dampingK;
        this.velocity = 0;
        this.target = 0;
    }

    /**
     * 创建一个临界阻尼的弹簧（或接近临界阻尼）这个
     * 弹簧将快速移动到其目标而不会超过
     *
     * @param springK
     *          弹簧常数 - 弹簧常数越高，
     *          弹簧越快达到目标。值为100给出了一个合理的值
     *          响应时间在一秒左右，较高的值会提供更快的
     *          响应。
     */
    public FloatSpring(float springK) {
        this(springK, (float) (2 * Math.sqrt(springK)));
    }

    /**
     * 更新弹簧的位置。这会更新“位置”，就好像在当前位置和目标
     * 位置之间拉伸了一个阻尼弹簧。也就是说，弹簧将倾向于将位置拉向
     *目标，并且如果弹簧被阻尼，位置将最终解决到目标上。
     *
     * @param target
     *          弹簧拉动位置的目标
     * @param time
     *          以秒计算的经过时间
     */
    public void update(float target, float time) {

        // 要求的位移量
        float v = position - target;

        //乘以弹簧常数得到弹簧力，减去阻尼力
        v = v * -springK - velocity * dampingK;

        // v现在是一个力，所以假设单位质量也是加速度。乘以经过时间得到速度变化
        velocity += v * time;

        // 如果速度无效，则将其归零
        if (Float.isNaN(velocity) || Float.isInfinite(velocity)) {
            velocity = 0;
        }

        // 以新速度改变位置，用于经过时间
        position += velocity * time;
    }

    /**
     * @return 阻尼常数越高，阻尼越强
     */
    public float getDampingK() {
        return dampingK;
    }

    /**
     * @param dampingK
     *         阻尼常数越高，阻尼越强
     */
    public void setDampingK(float dampingK) {
        this.dampingK = dampingK;
    }

    /**
     * @return 模拟弹簧终点的当前位置,当模拟变化时，发生改变
     *
     */
    public float getPosition() {
        return position;
    }

    /**
     * @param position
     *         模拟弹簧的新位置
     */
    public void setPosition(float position) {
        this.position = position;
    }

    /**
     * @return 弹簧常量 - 这个值越高，到达目标的速度越快
     */
    public float getSpringK() {
        return springK;
    }

    /**
     * @param springK
     *          弹簧常量 - 这个值越高，到达目标的速度越快
     */
    public void setSpringK(float springK) {
        this.springK = springK;
    }

    /**
     * @return 该位置的当前速度
     */
    public float getVelocity() {
        return velocity;
    }

    /**
     * @param velocity
     *         当前位置速度的新值
     */
    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    /**
     *
     * @param target
     *         弹簧起始位置的更新
     */
    public void setTarget(float target) {
        this.target = target;
    }

    /**
     *  获得弹簧起始位置
     * @return
     */
    public float getTarget() {
        return target;
    }

}
