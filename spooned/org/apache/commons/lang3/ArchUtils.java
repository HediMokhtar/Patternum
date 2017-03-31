

package org.apache.commons.lang3;


public class ArchUtils {
    private static final java.util.Map<java.lang.String, org.apache.commons.lang3.arch.Processor> ARCH_TO_PROCESSOR;

    static {
        ARCH_TO_PROCESSOR = new java.util.HashMap<>();
        org.apache.commons.lang3.ArchUtils.init();
    }

    private static final void init() {
        org.apache.commons.lang3.ArchUtils.init_X86_32Bit();
        org.apache.commons.lang3.ArchUtils.init_X86_64Bit();
        org.apache.commons.lang3.ArchUtils.init_IA64_32Bit();
        org.apache.commons.lang3.ArchUtils.init_IA64_64Bit();
        org.apache.commons.lang3.ArchUtils.init_PPC_32Bit();
        org.apache.commons.lang3.ArchUtils.init_PPC_64Bit();
    }

    private static final void init_X86_32Bit() {
        org.apache.commons.lang3.arch.Processor processor = new org.apache.commons.lang3.arch.Processor(org.apache.commons.lang3.arch.Processor.Arch.BIT_32, org.apache.commons.lang3.arch.Processor.Type.X86);
        org.apache.commons.lang3.ArchUtils.addProcessors(processor, "x86", "i386", "i486", "i586", "i686", "pentium");
    }

    private static final void init_X86_64Bit() {
        org.apache.commons.lang3.arch.Processor processor = new org.apache.commons.lang3.arch.Processor(org.apache.commons.lang3.arch.Processor.Arch.BIT_64, org.apache.commons.lang3.arch.Processor.Type.X86);
        org.apache.commons.lang3.ArchUtils.addProcessors(processor, "x86_64", "amd64", "em64t", "universal");
    }

    private static final void init_IA64_32Bit() {
        org.apache.commons.lang3.arch.Processor processor = new org.apache.commons.lang3.arch.Processor(org.apache.commons.lang3.arch.Processor.Arch.BIT_32, org.apache.commons.lang3.arch.Processor.Type.IA_64);
        org.apache.commons.lang3.ArchUtils.addProcessors(processor, "ia64_32", "ia64n");
    }

    private static final void init_IA64_64Bit() {
        org.apache.commons.lang3.arch.Processor processor = new org.apache.commons.lang3.arch.Processor(org.apache.commons.lang3.arch.Processor.Arch.BIT_64, org.apache.commons.lang3.arch.Processor.Type.IA_64);
        org.apache.commons.lang3.ArchUtils.addProcessors(processor, "ia64", "ia64w");
    }

    private static final void init_PPC_32Bit() {
        org.apache.commons.lang3.arch.Processor processor = new org.apache.commons.lang3.arch.Processor(org.apache.commons.lang3.arch.Processor.Arch.BIT_32, org.apache.commons.lang3.arch.Processor.Type.PPC);
        org.apache.commons.lang3.ArchUtils.addProcessors(processor, "ppc", "power", "powerpc", "power_pc", "power_rs");
    }

    private static final void init_PPC_64Bit() {
        org.apache.commons.lang3.arch.Processor processor = new org.apache.commons.lang3.arch.Processor(org.apache.commons.lang3.arch.Processor.Arch.BIT_64, org.apache.commons.lang3.arch.Processor.Type.PPC);
        org.apache.commons.lang3.ArchUtils.addProcessors(processor, "ppc64", "power64", "powerpc64", "power_pc64", "power_rs64");
    }

    private static final void addProcessor(java.lang.String key, org.apache.commons.lang3.arch.Processor processor) throws java.lang.IllegalStateException {
        if (!(org.apache.commons.lang3.ArchUtils.ARCH_TO_PROCESSOR.containsKey(key))) {
            org.apache.commons.lang3.ArchUtils.ARCH_TO_PROCESSOR.put(key, processor);
        }else {
            java.lang.String msg = ("Key " + key) + " already exists in processor map";
            throw new java.lang.IllegalStateException(msg);
        }
    }

    private static final void addProcessors(org.apache.commons.lang3.arch.Processor processor, java.lang.String... keys) throws java.lang.IllegalStateException {
        for (java.lang.String key : keys) {
            org.apache.commons.lang3.ArchUtils.addProcessor(key, processor);
        }
    }

    public static final org.apache.commons.lang3.arch.Processor getProcessor() {
        return org.apache.commons.lang3.ArchUtils.getProcessor(org.apache.commons.lang3.SystemUtils.OS_ARCH);
    }

    public static final org.apache.commons.lang3.arch.Processor getProcessor(java.lang.String value) {
        return org.apache.commons.lang3.ArchUtils.ARCH_TO_PROCESSOR.get(value);
    }
}

