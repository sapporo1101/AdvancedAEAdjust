package io.github.sapporo1101.advancedaeadjust.resource;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;

@FunctionalInterface
public interface QuickResourceModifier {
    byte @Nullable [] modify(byte[] data) throws IOException;
}