package com.ardublock.translator.block.evshield;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SHMotor1 extends TranslatorBlock {
	public SHMotor1 (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	@Override
	public String toCode() throws SocketNullException,
			SubroutineNotDeclaredException, BlockException {
		
		translator.addHeaderFile("EVShield.h");

		
		return codePrefix + "SH_Motor_1" + codeSuffix;
	}

}
