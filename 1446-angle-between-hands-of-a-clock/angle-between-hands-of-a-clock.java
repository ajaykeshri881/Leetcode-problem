class Solution {
    public double angleClock(int hour, int minutes) {

        double hourAngle = (hour * 30) + (minutes * 0.5);
        double minuteAngle = minutes * 6;
        double diff = Math.abs(hourAngle - minuteAngle);

        return Math.min(diff, 360 - diff);
    }
}

/* 
class Solution {
    public double angleClock(int hour, int minutes) {

        double hourAngle = hour * 30;
        
        for (int i = 0; i < minutes; i++) {
            hourAngle += 0.5;
        }

        double minuteAngle = minutes * 6;

        double diff = Math.abs(hourAngle - minuteAngle);

        return Math.min(diff, 360 - diff);
    }
}
 */