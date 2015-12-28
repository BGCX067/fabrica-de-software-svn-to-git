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

public class Task {
    Timer timer;
    AgendaView agenda;
    public Task(int seconds, AgendaView agenda) {
        timer = new Timer();
        this.agenda = agenda;
        timer.schedule(new RemindTask(), seconds*1000);
        this.agenda.Atualizar();
    }

    class RemindTask extends TimerTask {
        public void run() {
            timer.cancel(); //Terminate the timer thread
            new Task(300, agenda);
        }
    }

}