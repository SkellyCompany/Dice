package com.example.dice;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class DiceContainer extends LinearLayout {

    private static final int INITIAL_DICE_COUNT = 1;
    private static final int MIN_DICE_COUNT = 0;
    private static final int MAX_DICE_COUNT = 6;

    private Context ct;
    private int diceCount;

    public DiceContainer(Context ct, AttributeSet attrs)
    {
        super(ct, attrs);
        this.ct = ct;
        initializeDices();
    }

    private void initializeDices()
    {
        for(int i = 0; i < INITIAL_DICE_COUNT; i++)
        {
            addDice();
        }
    }

    public void addDice()
    {
        if(diceCount < MAX_DICE_COUNT)
        {
            if(diceCount == 0)
            {
                DiceRow diceRow = new DiceRow(ct);
                diceRow.addDice();
                addView(diceRow);
            }
            else if(diceCount == 1)
            {
                DiceRow diceRow = (DiceRow) getChildAt(0);
                diceRow.addDice();
            }
            else if(diceCount == 2)
            {
                DiceRow diceRow = new DiceRow(ct);
                diceRow.addDice();
                addView(diceRow);
            }
            else if(diceCount%2 == 0)
            {
                DiceRow diceRow = (DiceRow) getChildAt(0);
                diceRow.addDice();
            }
            else
            {
                DiceRow diceRow = (DiceRow) getChildAt(1);
                diceRow.addDice();
            }
            diceCount++;
            adjustDiceSizes();

        }

    }

    private void adjustDiceSizes()
    {
        Dice.DiceSize size;
        if(diceCount < 2)
        {
            size = Dice.DiceSize.BIG;
        }
        else if(diceCount < 5)
        {
            size = Dice.DiceSize.MEDIUM;
        }
        else
        {
            size = Dice.DiceSize.SMALL;
        }
        for(int i = 0; i < getChildCount(); i++)
        {
            DiceRow diceRow = (DiceRow) getChildAt(i);
            diceRow.setDiceSizes(size);
        }
    }

}
