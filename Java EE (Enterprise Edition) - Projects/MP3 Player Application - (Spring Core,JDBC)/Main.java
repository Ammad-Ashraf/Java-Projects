package Ammad.Projectname;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
public class Driver_Task02
{

    @Autowired
    private MP3Player mp3;

    public void play()
    {
        mp3.playKalaam();
    }

    public static void main(String[] args)
    {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("KalaamBeans.xml"))
        {
            Driver_Task02 driver = context.getBean("driver",Driver_Task02.class);
            driver.play();
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
