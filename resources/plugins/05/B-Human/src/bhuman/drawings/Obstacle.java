package bhuman.drawings;

import bhuman.message.BHumanMessage;
import bhuman.message.messages.ObstacleModelCompressed;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import teamcomm.gui.Camera;
import teamcomm.data.RobotState;
import teamcomm.gui.drawings.PerPlayer;

/**
 *
 * @author Felix Thielke
 */
public class Obstacle extends PerPlayer {

    public static final float OPACITY = 0.75f;

    @Override
    public void draw(final GL2 gl, final RobotState rs, final Camera camera) {
        if (rs.getLastMessage() != null
                && rs.getLastMessage() instanceof BHumanMessage) {
            final BHumanMessage msg = (BHumanMessage) rs.getLastMessage();
            final ObstacleModelCompressed obstacleModel = msg.queue
                    .getMessage(ObstacleModelCompressed.class);
            if (obstacleModel != null) {
                final GLU glu = GLU.createGLU(gl);
                final GLUquadric q = glu.gluNewQuadric();

                // Enable transparency
                gl.glEnable(GL2.GL_BLEND);
                gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);

                // Draw obstacles
                for (final ObstacleModelCompressed.Obstacle obstacle : obstacleModel.obstacles) {
                    // Set color
                    switch (obstacle.type) {
                        case ULTRASOUND:
                            gl.glColor4f(0.f, 0.f, 1.f, OPACITY);
                            break;
                        case GOALPOST:
                            gl.glColor4f(1.f, 1.f, 0.f, OPACITY);
                            break;
                        case FALLENSOMEROBOT:
                        case SOMEROBOT:
                            gl.glColor4f(1.f, .5f, 0.f, OPACITY);
                            break;
                        case FALLENOPPONENT:
                        case OPPONENT:
                            gl.glColor4f(1.f, 0.f, 1.f, OPACITY);
                            break;
                        case FALLENTEAMMATE:
                        case TEAMMATE:
                            gl.glColor4f(0.f, 1.f, 1.f, OPACITY);
                            break;
                        default:
                            gl.glColor4f(0.f, 0.f, 0.f, OPACITY);
                            break;
                    }

                    gl.glPushMatrix();
                    gl.glTranslatef(msg.pose[0] / 1000.0f, msg.pose[1] / 1000.f, 0);
                    gl.glRotatef(msg.pose[2], 0, 0, 1);

                    // Translate to obstacle
                    gl.glBegin(gl.GL_LINE_STRIP);
                    gl.glVertex3f(obstacle.left.x / 1000.f, obstacle.left.y / 1000.f, 0.f);
                    gl.glVertex3f(obstacle.center.x / 1000.f, obstacle.center.y / 1000.f, 0.f);
                    gl.glVertex3f(obstacle.right.x / 1000.f, obstacle.right.y / 1000.f, 0.f);
                    gl.glEnd();

                    // Draw line from obstacle to robot to determine which player saw that obstacle
                    gl.glBegin(gl.GL_LINES);
                    gl.glVertex3f(0.f, 0.f, 0.f);
                    gl.glVertex3f(obstacle.center.x / 1000.f, obstacle.center.y / 1000.f, 0.f);
                    gl.glEnd();

                    // Translate back
                    gl.glPopMatrix();
                }
                // Disable transparency
                gl.glDisable(GL2.GL_BLEND);

                glu.gluDeleteQuadric(q);
            }
        }
    }

    @Override
    public boolean hasAlpha() {
        return true;
    }

    @Override
    public int getPriority() {
        return 100;
    }
}
