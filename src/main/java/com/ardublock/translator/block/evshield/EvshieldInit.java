package com.ardublock.translator.block.evshield;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EvshieldInit extends TranslatorBlock {
	
	public EvshieldInit (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	@Override
	public String toCode() throws SocketNullException,
			SubroutineNotDeclaredException, BlockException {

		translator.addHeaderFile("EVShield.h");
		translator.addHeaderFile("Wire.h");
		translator.addDefinitionCommand("EVShield evshield(0x34,0x36);");
		translator.addSetupCommand("evshield.init( SH_HardwareI2C );");
		return "";
	}

}
