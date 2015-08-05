package com.ardublock.translator.block.evshield;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class MotorSpeed extends TranslatorBlock {
	
	public MotorSpeed (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	@Override
	public String toCode() throws SocketNullException,
			SubroutineNotDeclaredException, BlockException {

		TranslatorBlock bank = this.getRequiredTranslatorBlockAtSocket(0);
		TranslatorBlock motor = this.getRequiredTranslatorBlockAtSocket(1);
		TranslatorBlock speed = this.getRequiredTranslatorBlockAtSocket(2);
		
		
		return codePrefix + "evshield." + bank.toCode() + ".motorRunUnlimited  ( " + motor.toCode() + ", SH_Direction_Forward, " + speed.toCode() + ");" + codeSuffix;
	}

}
