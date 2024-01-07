package tools.jackson.module.kotlin.test.parameterSize

import tools.jackson.module.kotlin.assertReflectEquals
import tools.jackson.module.kotlin.callPrimaryConstructor
import tools.jackson.module.kotlin.defaultMapper
import tools.jackson.module.kotlin.readValue
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Up to argument size 32 there is one mask argument for the default argument,
 * 33 ~ 64 there are two, and 65 there are three, so each boundary value is tested.
 * Also, the maximum argument size that can be set in the constructor is 254, so that case is tested as well.
 */
class DeserializeByConstructorWithoutDefaultArgumentsTest {
    data class Dst32(
        val p00: String,
        val p01: String,
        val p02: String,
        val p03: String,
        val p04: String,
        val p05: String,
        val p06: String,
        val p07: String,
        val p08: String,
        val p09: String,
        val p10: String,
        val p11: String,
        val p12: String,
        val p13: String,
        val p14: String,
        val p15: String,
        val p16: String,
        val p17: String,
        val p18: String,
        val p19: String,
        val p20: String,
        val p21: String,
        val p22: String,
        val p23: String,
        val p24: String,
        val p25: String,
        val p26: String,
        val p27: String,
        val p28: String,
        val p29: String,
        val p30: String,
        val p31: String
    )

    @Test
    fun test32() {
        val expected = callPrimaryConstructor<Dst32>()
        val src = defaultMapper.writeValueAsString(expected)
        assertEquals(expected, defaultMapper.readValue<Dst32>(src))
    }

    data class Dst33(
        val p00: String,
        val p01: String,
        val p02: String,
        val p03: String,
        val p04: String,
        val p05: String,
        val p06: String,
        val p07: String,
        val p08: String,
        val p09: String,
        val p10: String,
        val p11: String,
        val p12: String,
        val p13: String,
        val p14: String,
        val p15: String,
        val p16: String,
        val p17: String,
        val p18: String,
        val p19: String,
        val p20: String,
        val p21: String,
        val p22: String,
        val p23: String,
        val p24: String,
        val p25: String,
        val p26: String,
        val p27: String,
        val p28: String,
        val p29: String,
        val p30: String,
        val p31: String,
        val p32: String
    )

    @Test
    fun test33() {
        val expected = callPrimaryConstructor<Dst33>()
        val src = defaultMapper.writeValueAsString(expected)
        assertEquals(expected, defaultMapper.readValue<Dst33>(src))
    }

    data class Dst64(
        val p00: String,
        val p01: String,
        val p02: String,
        val p03: String,
        val p04: String,
        val p05: String,
        val p06: String,
        val p07: String,
        val p08: String,
        val p09: String,
        val p10: String,
        val p11: String,
        val p12: String,
        val p13: String,
        val p14: String,
        val p15: String,
        val p16: String,
        val p17: String,
        val p18: String,
        val p19: String,
        val p20: String,
        val p21: String,
        val p22: String,
        val p23: String,
        val p24: String,
        val p25: String,
        val p26: String,
        val p27: String,
        val p28: String,
        val p29: String,
        val p30: String,
        val p31: String,
        val p32: String,
        val p33: String,
        val p34: String,
        val p35: String,
        val p36: String,
        val p37: String,
        val p38: String,
        val p39: String,
        val p40: String,
        val p41: String,
        val p42: String,
        val p43: String,
        val p44: String,
        val p45: String,
        val p46: String,
        val p47: String,
        val p48: String,
        val p49: String,
        val p50: String,
        val p51: String,
        val p52: String,
        val p53: String,
        val p54: String,
        val p55: String,
        val p56: String,
        val p57: String,
        val p58: String,
        val p59: String,
        val p60: String,
        val p61: String,
        val p62: String,
        val p63: String
    )

    @Test
    fun test64() {
        val expected = callPrimaryConstructor<Dst64>()
        val src = defaultMapper.writeValueAsString(expected)
        assertEquals(expected, defaultMapper.readValue<Dst64>(src))
    }

    data class Dst65(
        val p00: String,
        val p01: String,
        val p02: String,
        val p03: String,
        val p04: String,
        val p05: String,
        val p06: String,
        val p07: String,
        val p08: String,
        val p09: String,
        val p10: String,
        val p11: String,
        val p12: String,
        val p13: String,
        val p14: String,
        val p15: String,
        val p16: String,
        val p17: String,
        val p18: String,
        val p19: String,
        val p20: String,
        val p21: String,
        val p22: String,
        val p23: String,
        val p24: String,
        val p25: String,
        val p26: String,
        val p27: String,
        val p28: String,
        val p29: String,
        val p30: String,
        val p31: String,
        val p32: String,
        val p33: String,
        val p34: String,
        val p35: String,
        val p36: String,
        val p37: String,
        val p38: String,
        val p39: String,
        val p40: String,
        val p41: String,
        val p42: String,
        val p43: String,
        val p44: String,
        val p45: String,
        val p46: String,
        val p47: String,
        val p48: String,
        val p49: String,
        val p50: String,
        val p51: String,
        val p52: String,
        val p53: String,
        val p54: String,
        val p55: String,
        val p56: String,
        val p57: String,
        val p58: String,
        val p59: String,
        val p60: String,
        val p61: String,
        val p62: String,
        val p63: String,
        val p64: String
    )

    @Test
    fun test65() {
        val expected = callPrimaryConstructor<Dst65>()
        val src = defaultMapper.writeValueAsString(expected)
        assertEquals(expected, defaultMapper.readValue<Dst65>(src))
    }

    // It cannot be a data class because the generated method would exceed the argument size limit.
    class DstMax(
        val p000: String,
        val p001: String,
        val p002: String,
        val p003: String,
        val p004: String,
        val p005: String,
        val p006: String,
        val p007: String,
        val p008: String,
        val p009: String,
        val p010: String,
        val p011: String,
        val p012: String,
        val p013: String,
        val p014: String,
        val p015: String,
        val p016: String,
        val p017: String,
        val p018: String,
        val p019: String,
        val p020: String,
        val p021: String,
        val p022: String,
        val p023: String,
        val p024: String,
        val p025: String,
        val p026: String,
        val p027: String,
        val p028: String,
        val p029: String,
        val p030: String,
        val p031: String,
        val p032: String,
        val p033: String,
        val p034: String,
        val p035: String,
        val p036: String,
        val p037: String,
        val p038: String,
        val p039: String,
        val p040: String,
        val p041: String,
        val p042: String,
        val p043: String,
        val p044: String,
        val p045: String,
        val p046: String,
        val p047: String,
        val p048: String,
        val p049: String,
        val p050: String,
        val p051: String,
        val p052: String,
        val p053: String,
        val p054: String,
        val p055: String,
        val p056: String,
        val p057: String,
        val p058: String,
        val p059: String,
        val p060: String,
        val p061: String,
        val p062: String,
        val p063: String,
        val p064: String,
        val p065: String,
        val p066: String,
        val p067: String,
        val p068: String,
        val p069: String,
        val p070: String,
        val p071: String,
        val p072: String,
        val p073: String,
        val p074: String,
        val p075: String,
        val p076: String,
        val p077: String,
        val p078: String,
        val p079: String,
        val p080: String,
        val p081: String,
        val p082: String,
        val p083: String,
        val p084: String,
        val p085: String,
        val p086: String,
        val p087: String,
        val p088: String,
        val p089: String,
        val p090: String,
        val p091: String,
        val p092: String,
        val p093: String,
        val p094: String,
        val p095: String,
        val p096: String,
        val p097: String,
        val p098: String,
        val p099: String,
        val p100: String,
        val p101: String,
        val p102: String,
        val p103: String,
        val p104: String,
        val p105: String,
        val p106: String,
        val p107: String,
        val p108: String,
        val p109: String,
        val p110: String,
        val p111: String,
        val p112: String,
        val p113: String,
        val p114: String,
        val p115: String,
        val p116: String,
        val p117: String,
        val p118: String,
        val p119: String,
        val p120: String,
        val p121: String,
        val p122: String,
        val p123: String,
        val p124: String,
        val p125: String,
        val p126: String,
        val p127: String,
        val p128: String,
        val p129: String,
        val p130: String,
        val p131: String,
        val p132: String,
        val p133: String,
        val p134: String,
        val p135: String,
        val p136: String,
        val p137: String,
        val p138: String,
        val p139: String,
        val p140: String,
        val p141: String,
        val p142: String,
        val p143: String,
        val p144: String,
        val p145: String,
        val p146: String,
        val p147: String,
        val p148: String,
        val p149: String,
        val p150: String,
        val p151: String,
        val p152: String,
        val p153: String,
        val p154: String,
        val p155: String,
        val p156: String,
        val p157: String,
        val p158: String,
        val p159: String,
        val p160: String,
        val p161: String,
        val p162: String,
        val p163: String,
        val p164: String,
        val p165: String,
        val p166: String,
        val p167: String,
        val p168: String,
        val p169: String,
        val p170: String,
        val p171: String,
        val p172: String,
        val p173: String,
        val p174: String,
        val p175: String,
        val p176: String,
        val p177: String,
        val p178: String,
        val p179: String,
        val p180: String,
        val p181: String,
        val p182: String,
        val p183: String,
        val p184: String,
        val p185: String,
        val p186: String,
        val p187: String,
        val p188: String,
        val p189: String,
        val p190: String,
        val p191: String,
        val p192: String,
        val p193: String,
        val p194: String,
        val p195: String,
        val p196: String,
        val p197: String,
        val p198: String,
        val p199: String,
        val p200: String,
        val p201: String,
        val p202: String,
        val p203: String,
        val p204: String,
        val p205: String,
        val p206: String,
        val p207: String,
        val p208: String,
        val p209: String,
        val p210: String,
        val p211: String,
        val p212: String,
        val p213: String,
        val p214: String,
        val p215: String,
        val p216: String,
        val p217: String,
        val p218: String,
        val p219: String,
        val p220: String,
        val p221: String,
        val p222: String,
        val p223: String,
        val p224: String,
        val p225: String,
        val p226: String,
        val p227: String,
        val p228: String,
        val p229: String,
        val p230: String,
        val p231: String,
        val p232: String,
        val p233: String,
        val p234: String,
        val p235: String,
        val p236: String,
        val p237: String,
        val p238: String,
        val p239: String,
        val p240: String,
        val p241: String,
        val p242: String,
        val p243: String,
        val p244: String,
        val p245: String,
        val p246: String,
        val p247: String,
        val p248: String,
        val p249: String,
        val p250: String,
        val p251: String,
        val p252: String,
        val p253: String
    )

    @Test
    fun testMax() {
        val expected = callPrimaryConstructor<DstMax>()
        val src = defaultMapper.writeValueAsString(expected)
        assertReflectEquals(expected, defaultMapper.readValue<DstMax>(src))
    }
}
