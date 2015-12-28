/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package atualiza;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import model.atualizaDao;


/**
 * Simple demo that uses java.util.Timer to schedule a task
 * to execute once 5 seconds have passed.
 */

public class IvvTask {
    Timer timer;
    int minutos = 0;
    int dias = 0;
    public IvvTask(int seconds, int dias) {
        timer = new Timer();
        minutos = (seconds * 60) * 1000;
        this.dias = dias;
        timer.schedule(new RemindAlertaTask(), minutos);

    }

    class RemindAlertaTask extends TimerTask {
        public void run() {
            timer.cancel(); //Terminate the timer thread

            //inicio do processamento

            DateFormat dtformat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar datain = Calendar.getInstance();
            Calendar datafin = Calendar.getInstance();
            datafin.setTime(new Date());
            datain.setTime(datafin.getTime());
            datain.add(Calendar.DAY_OF_MONTH, dias);
            new atualizaDao().ProcessaEntrada(new atualizaDao().consulta(dtformat.format(datain.getTime()), dtformat.format(datafin.getTime())));

            //fim do processamento
            timer = new Timer();
            timer.schedule(new RemindAlertaTask(), minutos);
            //new IvvTask(minutos,dias);
        }
    }

}