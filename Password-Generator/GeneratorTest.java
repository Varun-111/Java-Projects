package com.varun2pwd;
import org.somepackage.SomeClass;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class GeneratorTest {
	private final Password password = new Password("Secret");
	private final Alphabet firstAlphabet = new Alphabet(true, false, false, false);
	private final Alphabet secondAlphabet = new Alphabet(false, true, true, true);
	private final Generator generator = new Generator(true, false, false, false);
	// private final Password generatedPassword = generator.GeneratePassword(4);
	
	@Test
	void test1() {
		assertEquals("Secret", password.toString());
		
	}
	
	@Test
	void test2() {
		assertEquals(firstAlphabet.getAlphabet(), Alphabet.Uppercase_letters);
		
	}
	
	@Test
	void test3() {
		assertEquals(secondAlphabet.getAlphabet(), Alphabet.Lowercase_Letters + Alphabet.Numbers + Alphabet.Symbols);
	}
	
	@Test
	void test4() {
		assertEquals(generator.alphabet.getAlphabet(), Alphabet.Uppercase_letters);
	}
	
	void test5() {
		assertEquals(generator.alphabet.getAlphabet().length(), 26);
	}
}	

