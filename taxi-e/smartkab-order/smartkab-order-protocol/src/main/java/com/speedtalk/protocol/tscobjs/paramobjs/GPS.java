package com.speedtalk.protocol.tscobjs.paramobjs;


import com.speedtalk.protocol.IMsParam;
import com.speedtalk.protocol.constants.ParamConstants;


public class GPS implements IMsParam {
    private int move;
    private int distance;
    private int stop;


    public GPS(int move, int distance, int stop) {
        /*  16 */
        this.move = move;
        /*  17 */
        this.distance = distance;
        /*  18 */
        this.stop = stop;

    }


    public int getMove() {
        /*  28 */
        return this.move;

    }


    public void setMove(int move) {
        /*  37 */
        this.move = move;

    }


    public int getDistance() {
        /*  47 */
        return this.distance;

    }


    public void setDistance(int distance) {
        /*  56 */
        this.distance = distance;

    }


    public int getStop() {
        /*  65 */
        return this.stop;

    }


    public void setStop(int stop) {
        /*  74 */
        this.stop = stop;

    }


    public String toString() {
        /*  80 */
        StringBuilder buffer = new StringBuilder();
        /*  81 */
        if (ParamConstants.isDetail()) {
            /*  83 */
            buffer.append(" GPS:Move interval(Second):");
            /*  84 */
            buffer.append(getMove());
            /*  85 */
            buffer.append(",Move distance:");
            /*  86 */
            buffer.append(getDistance());
            /*  87 */
            buffer.append(",Stop interval:");
            /*  88 */
            buffer.append(getStop());

        } else {
            /*  92 */
            buffer.append(" :");
            /*  93 */
            buffer.append(getMove());
            /*  94 */
            buffer.append(",");
            /*  95 */
            buffer.append(getDistance());
            /*  96 */
            buffer.append(",");
            /*  97 */
            buffer.append(getStop());

        }

        /* 100 */
        return buffer.toString();

    }

}

