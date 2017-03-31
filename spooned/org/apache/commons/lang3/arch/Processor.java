

package org.apache.commons.lang3.arch;


public class Processor {
    public enum Arch {
BIT_32, BIT_64, UNKNOWN;    }

    public enum Type {
X86, IA_64, PPC, UNKNOWN;    }

    private final org.apache.commons.lang3.arch.Processor.Arch arch;

    private final org.apache.commons.lang3.arch.Processor.Type type;

    public Processor(org.apache.commons.lang3.arch.Processor.Arch arch, org.apache.commons.lang3.arch.Processor.Type type) {
        this.arch = arch;
        this.type = type;
    }

    public org.apache.commons.lang3.arch.Processor.Arch getArch() {
        return arch;
    }

    public org.apache.commons.lang3.arch.Processor.Type getType() {
        return type;
    }

    public boolean is32Bit() {
        return org.apache.commons.lang3.arch.Processor.Arch.BIT_32.equals(arch);
    }

    public boolean is64Bit() {
        return org.apache.commons.lang3.arch.Processor.Arch.BIT_64.equals(arch);
    }

    public boolean isX86() {
        return org.apache.commons.lang3.arch.Processor.Type.X86.equals(type);
    }

    public boolean isIA64() {
        return org.apache.commons.lang3.arch.Processor.Type.IA_64.equals(type);
    }

    public boolean isPPC() {
        return org.apache.commons.lang3.arch.Processor.Type.PPC.equals(type);
    }
}

