/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import view.execucao.AgendaView;

/**
 * Simple demo that uses java.util.Timer to schedule a task
 * to execute once 5 seconds have passed.
 */

public class AlertaTask {
    Timer timer;
    AgendaView agenda;
    Alerta alerta;
    public AlertaTask(int seconds, AgendaView agenda, Alerta alerta) {
        timer = new Timer();
        this.agenda = agenda;
        this.alerta = alerta;
        timer.schedule(new RemindAlertaTask(), seconds*1000);

    }

    class RemindAlertaTask extends TimerTask {
        public void run() {
            timer.cancel(); //Terminate the timer thread
            //alerta.requestFocus();
            //alerta.toFront();
            if(alerta.getAlerta() == 0)
            {
            alerta.AdicionaLinha();
            alerta.VerificaDados();
            }
            timer = new Timer();
            timer.schedule(new RemindAlertaTask(), 10000);
            
            //new AlertaTask(10, agenda, alerta);
        }
    }

}