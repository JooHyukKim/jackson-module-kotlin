package com.fasterxml.jackson.module.kotlin.kogeraIntegration.deser.valueClass.parameterSize.nullableObject

import com.fasterxml.jackson.module.kotlin.assertReflectEquals
import com.fasterxml.jackson.module.kotlin.callPrimaryConstructor
import com.fasterxml.jackson.module.kotlin.defaultMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.kogeraIntegration.deser.valueClass.NullableObject
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test

/**
 * Up to argument size 32 there is one mask argument for the default argument,
 * 33 ~ 64 there are two, and 65 there are three, so each boundary value is tested.
 * Also, the maximum size of arguments that can be set by a constructor
 * that includes a value class as an argument is 253 (one less by DefaultConstructorMarker), so test that case as well.
 */
class DeserializeByConstructorWithoutDefaultArgumentsTest {
    data class Dst32(
        val p00: NullableObject,
        val p01: NullableObject,
        val p02: NullableObject,
        val p03: NullableObject,
        val p04: NullableObject,
        val p05: NullableObject,
        val p06: NullableObject,
        val p07: NullableObject,
        val p08: NullableObject,
        val p09: NullableObject,
        val p10: NullableObject,
        val p11: NullableObject,
        val p12: NullableObject,
        val p13: NullableObject,
        val p14: NullableObject,
        val p15: NullableObject,
        val p16: NullableObject,
        val p17: NullableObject,
        val p18: NullableObject,
        val p19: NullableObject,
        val p20: NullableObject,
        val p21: NullableObject,
        val p22: NullableObject,
        val p23: NullableObject,
        val p24: NullableObject,
        val p25: NullableObject,
        val p26: NullableObject,
        val p27: NullableObject,
        val p28: NullableObject,
        val p29: NullableObject,
        val p30: NullableObject,
        val p31: NullableObject
    )

    @Test
    fun test32() {
        val expected = callPrimaryConstructor<Dst32> { NullableObject(it.name!!) }
        val src = defaultMapper.writeValueAsString(expected)
        assertEquals(expected, defaultMapper.readValue<Dst32>(src))
    }

    data class Dst33(
        val p00: NullableObject,
        val p01: NullableObject,
        val p02: NullableObject,
        val p03: NullableObject,
        val p04: NullableObject,
        val p05: NullableObject,
        val p06: NullableObject,
        val p07: NullableObject,
        val p08: NullableObject,
        val p09: NullableObject,
        val p10: NullableObject,
        val p11: NullableObject,
        val p12: NullableObject,
        val p13: NullableObject,
        val p14: NullableObject,
        val p15: NullableObject,
        val p16: NullableObject,
        val p17: NullableObject,
        val p18: NullableObject,
        val p19: NullableObject,
        val p20: NullableObject,
        val p21: NullableObject,
        val p22: NullableObject,
        val p23: NullableObject,
        val p24: NullableObject,
        val p25: NullableObject,
        val p26: NullableObject,
        val p27: NullableObject,
        val p28: NullableObject,
        val p29: NullableObject,
        val p30: NullableObject,
        val p31: NullableObject,
        val p32: NullableObject
    )

    @Test
    fun test33() {
        val expected = callPrimaryConstructor<Dst33> { NullableObject(it.name!!) }
        val src = defaultMapper.writeValueAsString(expected)
        assertEquals(expected, defaultMapper.readValue<Dst33>(src))
    }

    data class Dst64(
        val p00: NullableObject,
        val p01: NullableObject,
        val p02: NullableObject,
        val p03: NullableObject,
        val p04: NullableObject,
        val p05: NullableObject,
        val p06: NullableObject,
        val p07: NullableObject,
        val p08: NullableObject,
        val p09: NullableObject,
        val p10: NullableObject,
        val p11: NullableObject,
        val p12: NullableObject,
        val p13: NullableObject,
        val p14: NullableObject,
        val p15: NullableObject,
        val p16: NullableObject,
        val p17: NullableObject,
        val p18: NullableObject,
        val p19: NullableObject,
        val p20: NullableObject,
        val p21: NullableObject,
        val p22: NullableObject,
        val p23: NullableObject,
        val p24: NullableObject,
        val p25: NullableObject,
        val p26: NullableObject,
        val p27: NullableObject,
        val p28: NullableObject,
        val p29: NullableObject,
        val p30: NullableObject,
        val p31: NullableObject,
        val p32: NullableObject,
        val p33: NullableObject,
        val p34: NullableObject,
        val p35: NullableObject,
        val p36: NullableObject,
        val p37: NullableObject,
        val p38: NullableObject,
        val p39: NullableObject,
        val p40: NullableObject,
        val p41: NullableObject,
        val p42: NullableObject,
        val p43: NullableObject,
        val p44: NullableObject,
        val p45: NullableObject,
        val p46: NullableObject,
        val p47: NullableObject,
        val p48: NullableObject,
        val p49: NullableObject,
        val p50: NullableObject,
        val p51: NullableObject,
        val p52: NullableObject,
        val p53: NullableObject,
        val p54: NullableObject,
        val p55: NullableObject,
        val p56: NullableObject,
        val p57: NullableObject,
        val p58: NullableObject,
        val p59: NullableObject,
        val p60: NullableObject,
        val p61: NullableObject,
        val p62: NullableObject,
        val p63: NullableObject
    )

    @Test
    fun test64() {
        val expected = callPrimaryConstructor<Dst64> { NullableObject(it.name!!) }
        val src = defaultMapper.writeValueAsString(expected)
        assertEquals(expected, defaultMapper.readValue<Dst64>(src))
    }

    data class Dst65(
        val p00: NullableObject,
        val p01: NullableObject,
        val p02: NullableObject,
        val p03: NullableObject,
        val p04: NullableObject,
        val p05: NullableObject,
        val p06: NullableObject,
        val p07: NullableObject,
        val p08: NullableObject,
        val p09: NullableObject,
        val p10: NullableObject,
        val p11: NullableObject,
        val p12: NullableObject,
        val p13: NullableObject,
        val p14: NullableObject,
        val p15: NullableObject,
        val p16: NullableObject,
        val p17: NullableObject,
        val p18: NullableObject,
        val p19: NullableObject,
        val p20: NullableObject,
        val p21: NullableObject,
        val p22: NullableObject,
        val p23: NullableObject,
        val p24: NullableObject,
        val p25: NullableObject,
        val p26: NullableObject,
        val p27: NullableObject,
        val p28: NullableObject,
        val p29: NullableObject,
        val p30: NullableObject,
        val p31: NullableObject,
        val p32: NullableObject,
        val p33: NullableObject,
        val p34: NullableObject,
        val p35: NullableObject,
        val p36: NullableObject,
        val p37: NullableObject,
        val p38: NullableObject,
        val p39: NullableObject,
        val p40: NullableObject,
        val p41: NullableObject,
        val p42: NullableObject,
        val p43: NullableObject,
        val p44: NullableObject,
        val p45: NullableObject,
        val p46: NullableObject,
        val p47: NullableObject,
        val p48: NullableObject,
        val p49: NullableObject,
        val p50: NullableObject,
        val p51: NullableObject,
        val p52: NullableObject,
        val p53: NullableObject,
        val p54: NullableObject,
        val p55: NullableObject,
        val p56: NullableObject,
        val p57: NullableObject,
        val p58: NullableObject,
        val p59: NullableObject,
        val p60: NullableObject,
        val p61: NullableObject,
        val p62: NullableObject,
        val p63: NullableObject,
        val p64: NullableObject
    )

    @Test
    fun test65() {
        val expected = callPrimaryConstructor<Dst65> { NullableObject(it.name!!) }
        val src = defaultMapper.writeValueAsString(expected)
        assertEquals(expected, defaultMapper.readValue<Dst65>(src))
    }

    // It cannot be a data class because the generated method would exceed the argument size limit.
    class DstMax(
        val p000: NullableObject,
        val p001: NullableObject,
        val p002: NullableObject,
        val p003: NullableObject,
        val p004: NullableObject,
        val p005: NullableObject,
        val p006: NullableObject,
        val p007: NullableObject,
        val p008: NullableObject,
        val p009: NullableObject,
        val p010: NullableObject,
        val p011: NullableObject,
        val p012: NullableObject,
        val p013: NullableObject,
        val p014: NullableObject,
        val p015: NullableObject,
        val p016: NullableObject,
        val p017: NullableObject,
        val p018: NullableObject,
        val p019: NullableObject,
        val p020: NullableObject,
        val p021: NullableObject,
        val p022: NullableObject,
        val p023: NullableObject,
        val p024: NullableObject,
        val p025: NullableObject,
        val p026: NullableObject,
        val p027: NullableObject,
        val p028: NullableObject,
        val p029: NullableObject,
        val p030: NullableObject,
        val p031: NullableObject,
        val p032: NullableObject,
        val p033: NullableObject,
        val p034: NullableObject,
        val p035: NullableObject,
        val p036: NullableObject,
        val p037: NullableObject,
        val p038: NullableObject,
        val p039: NullableObject,
        val p040: NullableObject,
        val p041: NullableObject,
        val p042: NullableObject,
        val p043: NullableObject,
        val p044: NullableObject,
        val p045: NullableObject,
        val p046: NullableObject,
        val p047: NullableObject,
        val p048: NullableObject,
        val p049: NullableObject,
        val p050: NullableObject,
        val p051: NullableObject,
        val p052: NullableObject,
        val p053: NullableObject,
        val p054: NullableObject,
        val p055: NullableObject,
        val p056: NullableObject,
        val p057: NullableObject,
        val p058: NullableObject,
        val p059: NullableObject,
        val p060: NullableObject,
        val p061: NullableObject,
        val p062: NullableObject,
        val p063: NullableObject,
        val p064: NullableObject,
        val p065: NullableObject,
        val p066: NullableObject,
        val p067: NullableObject,
        val p068: NullableObject,
        val p069: NullableObject,
        val p070: NullableObject,
        val p071: NullableObject,
        val p072: NullableObject,
        val p073: NullableObject,
        val p074: NullableObject,
        val p075: NullableObject,
        val p076: NullableObject,
        val p077: NullableObject,
        val p078: NullableObject,
        val p079: NullableObject,
        val p080: NullableObject,
        val p081: NullableObject,
        val p082: NullableObject,
        val p083: NullableObject,
        val p084: NullableObject,
        val p085: NullableObject,
        val p086: NullableObject,
        val p087: NullableObject,
        val p088: NullableObject,
        val p089: NullableObject,
        val p090: NullableObject,
        val p091: NullableObject,
        val p092: NullableObject,
        val p093: NullableObject,
        val p094: NullableObject,
        val p095: NullableObject,
        val p096: NullableObject,
        val p097: NullableObject,
        val p098: NullableObject,
        val p099: NullableObject,
        val p100: NullableObject,
        val p101: NullableObject,
        val p102: NullableObject,
        val p103: NullableObject,
        val p104: NullableObject,
        val p105: NullableObject,
        val p106: NullableObject,
        val p107: NullableObject,
        val p108: NullableObject,
        val p109: NullableObject,
        val p110: NullableObject,
        val p111: NullableObject,
        val p112: NullableObject,
        val p113: NullableObject,
        val p114: NullableObject,
        val p115: NullableObject,
        val p116: NullableObject,
        val p117: NullableObject,
        val p118: NullableObject,
        val p119: NullableObject,
        val p120: NullableObject,
        val p121: NullableObject,
        val p122: NullableObject,
        val p123: NullableObject,
        val p124: NullableObject,
        val p125: NullableObject,
        val p126: NullableObject,
        val p127: NullableObject,
        val p128: NullableObject,
        val p129: NullableObject,
        val p130: NullableObject,
        val p131: NullableObject,
        val p132: NullableObject,
        val p133: NullableObject,
        val p134: NullableObject,
        val p135: NullableObject,
        val p136: NullableObject,
        val p137: NullableObject,
        val p138: NullableObject,
        val p139: NullableObject,
        val p140: NullableObject,
        val p141: NullableObject,
        val p142: NullableObject,
        val p143: NullableObject,
        val p144: NullableObject,
        val p145: NullableObject,
        val p146: NullableObject,
        val p147: NullableObject,
        val p148: NullableObject,
        val p149: NullableObject,
        val p150: NullableObject,
        val p151: NullableObject,
        val p152: NullableObject,
        val p153: NullableObject,
        val p154: NullableObject,
        val p155: NullableObject,
        val p156: NullableObject,
        val p157: NullableObject,
        val p158: NullableObject,
        val p159: NullableObject,
        val p160: NullableObject,
        val p161: NullableObject,
        val p162: NullableObject,
        val p163: NullableObject,
        val p164: NullableObject,
        val p165: NullableObject,
        val p166: NullableObject,
        val p167: NullableObject,
        val p168: NullableObject,
        val p169: NullableObject,
        val p170: NullableObject,
        val p171: NullableObject,
        val p172: NullableObject,
        val p173: NullableObject,
        val p174: NullableObject,
        val p175: NullableObject,
        val p176: NullableObject,
        val p177: NullableObject,
        val p178: NullableObject,
        val p179: NullableObject,
        val p180: NullableObject,
        val p181: NullableObject,
        val p182: NullableObject,
        val p183: NullableObject,
        val p184: NullableObject,
        val p185: NullableObject,
        val p186: NullableObject,
        val p187: NullableObject,
        val p188: NullableObject,
        val p189: NullableObject,
        val p190: NullableObject,
        val p191: NullableObject,
        val p192: NullableObject,
        val p193: NullableObject,
        val p194: NullableObject,
        val p195: NullableObject,
        val p196: NullableObject,
        val p197: NullableObject,
        val p198: NullableObject,
        val p199: NullableObject,
        val p200: NullableObject,
        val p201: NullableObject,
        val p202: NullableObject,
        val p203: NullableObject,
        val p204: NullableObject,
        val p205: NullableObject,
        val p206: NullableObject,
        val p207: NullableObject,
        val p208: NullableObject,
        val p209: NullableObject,
        val p210: NullableObject,
        val p211: NullableObject,
        val p212: NullableObject,
        val p213: NullableObject,
        val p214: NullableObject,
        val p215: NullableObject,
        val p216: NullableObject,
        val p217: NullableObject,
        val p218: NullableObject,
        val p219: NullableObject,
        val p220: NullableObject,
        val p221: NullableObject,
        val p222: NullableObject,
        val p223: NullableObject,
        val p224: NullableObject,
        val p225: NullableObject,
        val p226: NullableObject,
        val p227: NullableObject,
        val p228: NullableObject,
        val p229: NullableObject,
        val p230: NullableObject,
        val p231: NullableObject,
        val p232: NullableObject,
        val p233: NullableObject,
        val p234: NullableObject,
        val p235: NullableObject,
        val p236: NullableObject,
        val p237: NullableObject,
        val p238: NullableObject,
        val p239: NullableObject,
        val p240: NullableObject,
        val p241: NullableObject,
        val p242: NullableObject,
        val p243: NullableObject,
        val p244: NullableObject,
        val p245: NullableObject,
        val p246: NullableObject,
        val p247: NullableObject,
        val p248: NullableObject,
        val p249: NullableObject,
        val p250: NullableObject,
        val p251: NullableObject,
        val p252: NullableObject
    )

    @Test
    fun testMax() {
        val expected = callPrimaryConstructor<DstMax> { NullableObject(it.name!!) }
        val src = defaultMapper.writeValueAsString(expected)
        assertReflectEquals(expected, defaultMapper.readValue<DstMax>(src))
    }
}
