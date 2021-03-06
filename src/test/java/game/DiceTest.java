package game;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class DiceTest 
{
	Dice d;
	@Test
	/**
	 * Test si le retour du de est trop haut
	 */
	public void testRollDiceTooHigh () 
	{
		Random tooMuch = mock(Random.class);
		when(tooMuch.nextInt(anyInt())).thenReturn(7);
		d = new Dice();
		assertThrows(RuntimeException.class, () -> d.rollDice(tooMuch, 1));
	}
	
	/**
	 * Test si le retour du de est trop bas
	 */
	public void testRollDiceTooLow () 
	{
		Random tooLow = mock(Random.class);
		when(tooLow.nextInt(anyInt())).thenReturn(-1);
		d = new Dice();
		assertThrows(RuntimeException.class, () -> d.rollDice(tooLow, 1));
	}
}
