/* Generated By:JavaCC: Do not edit this line. Parser.java */
package conversation.parser;
import conversation.core.*;
import conversation.core.conditions.*;
import conversation.core.effects.*;
import java.util.*;

public class Parser implements ParserConstants {

/****************************************
 *  The Conversation Language Grammar starts here  *
 ****************************************/
  final public Conversation ConversationTopLevel() throws ParseException {
    Token t;
    DialogueAgent participant;
    Conversation c = new Conversation();
    Topic topic;
    jj_consume_token(CONVERSATION);
    t = jj_consume_token(IDENTIFIER);
                                     c.setLabel(t.image);
    jj_consume_token(SEMICOLON);
    label_1:
    while (true) {
      participant = Participant();
                                  c.addAgent(participant);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PARTICIPANT:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
    }
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STARTING:
      case TOPIC:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      topic = TopicNode();
                           c.getAllTopics().add(topic);
    }
    jj_consume_token(0);
     {if (true) return c;}
    throw new Error("Missing return statement in function");
  }

  final public DialogueAgent Participant() throws ParseException {
    Token t;
    Map<String, Object> attributes = null;
    jj_consume_token(PARTICIPANT);
    t = jj_consume_token(IDENTIFIER);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBRACE:
      jj_consume_token(LBRACE);
      attributes = Attributes();
      jj_consume_token(RBRACE);
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
        DialogueAgent agent = new DialogueAgent(t.image);
        if(attributes != null)
            agent.getAttributes().putAll(attributes);
        {if (true) return agent;}
    throw new Error("Missing return statement in function");
  }

  final public Topic TopicNode() throws ParseException {
    Topic.Builder builder = new Topic.Builder();
    Condition condition;
    Map<String, Object> attributes;
    DialogueBeat beat;
    Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STARTING:
      jj_consume_token(STARTING);
                 builder.starting = true;
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    jj_consume_token(TOPIC);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      t = jj_consume_token(IDENTIFIER);
                                                                       builder.label = t.image;
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    jj_consume_token(LBRACE);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case WHEN:
      condition = When();
                             builder.condition = condition;
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    attributes = Attributes();
                                   builder.attributes = attributes;
    label_3:
    while (true) {
      beat = BeatNode();
                             builder.beats.add(beat);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STARTING:
      case BEAT:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_3;
      }
    }
    jj_consume_token(RBRACE);
     {if (true) return builder.build();}
    throw new Error("Missing return statement in function");
  }

  final public DialogueBeat BeatNode() throws ParseException {
    DialogueBeat.Builder builder = new DialogueBeat.Builder();
    NodeGroup root;
    Condition condition;
    Map<String, Object> attributes;
    Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STARTING:
      jj_consume_token(STARTING);
                 builder.starting = true;
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
    jj_consume_token(BEAT);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      t = jj_consume_token(IDENTIFIER);
                                                                      builder.label = t.image;
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    jj_consume_token(LBRACE);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case WHEN:
      condition = When();
                             builder.condition = condition;
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    attributes = Attributes();
                                   builder.attributes = attributes;
    root = GroupNode();
                            builder.root = root;
    jj_consume_token(RBRACE);
     {if (true) return builder.build();}
    throw new Error("Missing return statement in function");
  }

  final public NodeGroup GroupNode() throws ParseException {
    DialogueNode leaf;
    NodeGroup group;
    NodeGroup.Builder builder = new NodeGroup.Builder();
    NodeLink link;
    Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SEQ:
      jj_consume_token(SEQ);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        t = jj_consume_token(IDENTIFIER);
                               builder.label = t.image;
        break;
      default:
        jj_la1[10] = jj_gen;
        ;
      }
                                                           builder.type = NodeGroup.Type.sequential;
      break;
    case OP:
      jj_consume_token(OP);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        t = jj_consume_token(IDENTIFIER);
                              builder.label = t.image;
        break;
      default:
        jj_la1[11] = jj_gen;
        ;
      }
                                                          builder.type = NodeGroup.Type.optional;
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(LBRACE);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NODE:
        leaf = LeafNode();
                             builder.nodes.add(leaf);
        break;
      case OP:
      case SEQ:
        group = GroupNode();
                               builder.nodes.add(group);
        break;
      case BIT_AND:
        link = LinkNode();
                             builder.nodes.add(link);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          jj_consume_token(COMMA);
          break;
        default:
          jj_la1[13] = jj_gen;
          ;
        }
        break;
      case BEAT:
        jj_consume_token(BEAT);
        jj_consume_token(BREAK);
                          builder.nodes.add(conversation.core.Node.BEAT_BREAK);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          jj_consume_token(COMMA);
          break;
        default:
          jj_la1[14] = jj_gen;
          ;
        }
        break;
      case TOPIC:
        jj_consume_token(TOPIC);
        jj_consume_token(BREAK);
                           builder.nodes.add(conversation.core.Node.TOPIC_BREAK);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          jj_consume_token(COMMA);
          break;
        default:
          jj_la1[15] = jj_gen;
          ;
        }
        break;
      case END:
        jj_consume_token(END);
        jj_consume_token(CONVERSATION);
                                builder.nodes.add(conversation.core.Node.CONVERSATION_END);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          jj_consume_token(COMMA);
          break;
        default:
          jj_la1[16] = jj_gen;
          ;
        }
        break;
      default:
        jj_la1[17] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TOPIC:
      case BEAT:
      case NODE:
      case OP:
      case SEQ:
      case END:
      case BIT_AND:
        ;
        break;
      default:
        jj_la1[18] = jj_gen;
        break label_4;
      }
    }
    jj_consume_token(RBRACE);
     {if (true) return builder.build();}
    throw new Error("Missing return statement in function");
  }

  final public NodeLink LinkNode() throws ParseException {
    Token t;
    jj_consume_token(BIT_AND);
    t = jj_consume_token(IDENTIFIER);
     {if (true) return new NodeLink(t.image);}
    throw new Error("Missing return statement in function");
  }

  final public DialogueNode LeafNode() throws ParseException {
    Token t;
    DialogueNode.Builder builder = new DialogueNode.Builder();
    Condition condition;
    Map<String, Object> attributes;
    List<Effect> effects;
    jj_consume_token(NODE);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      t = jj_consume_token(IDENTIFIER);
                              builder.label = t.image;
      break;
    default:
      jj_la1[19] = jj_gen;
      ;
    }
    jj_consume_token(LBRACE);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case WHEN:
      condition = When();
                             builder.condition = condition;
      break;
    default:
      jj_la1[20] = jj_gen;
      ;
    }
    attributes = Attributes();
                                   builder.attributes = attributes;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SET:
      effects = Effects();
                              builder.effects = effects;
      break;
    default:
      jj_la1[21] = jj_gen;
      ;
    }
    jj_consume_token(RBRACE);
     {if (true) return builder.build();}
    throw new Error("Missing return statement in function");
  }

  final public List<Effect> Effects() throws ParseException {
    List<Effect> r = new ArrayList<Effect>();
    Effect effect;
    jj_consume_token(SET);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[22] = jj_gen;
        break label_5;
      }
      effect = Effect();
                              r.add(effect);
      jj_consume_token(SEMICOLON);
    }
     {if (true) return r;}
    throw new Error("Missing return statement in function");
  }

  final public Effect Effect() throws ParseException {
    Token t;
    Object value;
    Effect effect;
    SetFlagEffect.ClearState clearState = SetFlagEffect.ClearState.never;
    t = jj_consume_token(IDENTIFIER);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASSIGN:
      jj_consume_token(ASSIGN);
      value = Value();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CLEAR:
        jj_consume_token(CLEAR);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case BEAT:
          jj_consume_token(BEAT);
                                                      clearState = SetFlagEffect.ClearState.beat;
          break;
        case TOPIC:
          jj_consume_token(TOPIC);
                                                                                                              clearState = SetFlagEffect.ClearState.topic;
          break;
        default:
          jj_la1[23] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[24] = jj_gen;
        ;
      }
             effect = new SetFlagEffect(t.image, value, clearState);
      break;
    case INCR:
      jj_consume_token(INCR);
                  effect = new IncrementFlagEffect(t.image);
      break;
    case DECR:
      jj_consume_token(DECR);
                  effect = new DecrementFlagEffect(t.image);
      break;
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
     {if (true) return effect;}
    throw new Error("Missing return statement in function");
  }

// literal or identifier
  final public Object Value() throws ParseException {
    Token value;
    Object result;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FLOATING_POINT_LITERAL:
      value = jj_consume_token(FLOATING_POINT_LITERAL);
                                            result = Double.valueOf(value.image);
      break;
    case INTEGER_LITERAL:
      value = jj_consume_token(INTEGER_LITERAL);
                                     result = Integer.valueOf(value.image);
      break;
    case STRING_LITERAL:
      value = jj_consume_token(STRING_LITERAL);
                                    result = value.image.substring(1,value.image.length()-1);
      break;
    case IDENTIFIER:
      value = jj_consume_token(IDENTIFIER);
                                result = value.image;
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
     {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Map<String, Object> Attributes() throws ParseException {
    Token key;
    Object value;
    Map<String, Object> r = new HashMap<String, Object>();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[27] = jj_gen;
        break label_6;
      }
      key = jj_consume_token(IDENTIFIER);
      jj_consume_token(COLON);
      value = Value();
                                                  r.put(key.image, value);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        jj_consume_token(COMMA);
        break;
      default:
        jj_la1[28] = jj_gen;
        ;
      }
    }
     {if (true) return r;}
    throw new Error("Missing return statement in function");
  }

  final public Condition When() throws ParseException {
    Condition result;
    jj_consume_token(WHEN);
    result = Condition();
     {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Condition Condition() throws ParseException {
    Condition r;
    Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LPAREN:
      jj_consume_token(LPAREN);
      r = Condition1();
      jj_consume_token(RPAREN);
      break;
    case BANG:
      jj_consume_token(BANG);
      r = Condition();
                              r = new Not(r);
      break;
    case IDENTIFIER:
      t = jj_consume_token(IDENTIFIER);
                        r = new LogicVariable(t.image);
      break;
    case LBRACKET:
      r = TestCondition();
      break;
    default:
      jj_la1[29] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
     {if (true) return r;}
    throw new Error("Missing return statement in function");
  }

// for and, or blocks.
  final public Condition Condition1() throws ParseException {
    Condition r;
    List<Condition> body = new ArrayList<Condition>();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
    case LPAREN:
    case LBRACKET:
    case BANG:
      r = Condition();
                     body.add(r);
      label_7:
      while (true) {
        jj_consume_token(SC_AND);
        r = Condition();
                                     body.add(r);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SC_AND:
          ;
          break;
        default:
          jj_la1[30] = jj_gen;
          break label_7;
        }
      }
                                                      {if (true) return new MultiAnd(body);}
      break;
    case SC_OR:
      label_8:
      while (true) {
        jj_consume_token(SC_OR);
        r = Condition();
                                    body.add(r);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SC_OR:
          ;
          break;
        default:
          jj_la1[31] = jj_gen;
          break label_8;
        }
      }
                                                     {if (true) return new MultiOr(body);}
      break;
    default:
      jj_la1[32] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Condition TestCondition() throws ParseException {
    SymbolExpression ex1, ex2;
    TestCondition.Operation op;
    jj_consume_token(LBRACKET);
    ex1 = SymbolExpression();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EQ:
      jj_consume_token(EQ);
            op = TestCondition.Operation.equals;
      break;
    case LT:
      jj_consume_token(LT);
            op = TestCondition.Operation.lessThan;
      break;
    case LE:
      jj_consume_token(LE);
            op = TestCondition.Operation.lessThanOrEqualTo;
      break;
    case GT:
      jj_consume_token(GT);
            op = TestCondition.Operation.greaterThan;
      break;
    case GE:
      jj_consume_token(GE);
            op = TestCondition.Operation.greaterThanOrEqualTo;
      break;
    case NE:
      jj_consume_token(NE);
            op = TestCondition.Operation.notEqual;
      break;
    default:
      jj_la1[33] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    ex2 = SymbolExpression();
    jj_consume_token(RBRACKET);
     {if (true) return new TestCondition(ex1, op, ex2);}
    throw new Error("Missing return statement in function");
  }

  final public SymbolExpression SymbolExpression() throws ParseException {
    Token t;
    SymbolExpression ex1, ex2;
    SymbolOperation.Operation op;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      t = jj_consume_token(IDENTIFIER);
                        {if (true) return new SymbolVariable(t.image);}
      break;
    case INTEGER_LITERAL:
      t = jj_consume_token(INTEGER_LITERAL);
                             {if (true) return new SymbolConstant(Integer.valueOf(t.image));}
      break;
    case FLOATING_POINT_LITERAL:
      t = jj_consume_token(FLOATING_POINT_LITERAL);
                                    {if (true) return new SymbolConstant(Double.valueOf(t.image));}
      break;
    case LBRACKET:
      jj_consume_token(LBRACKET);
      ex1 = SymbolExpression();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
                  op = SymbolOperation.Operation.add;
        break;
      case MINUS:
        jj_consume_token(MINUS);
                   op = SymbolOperation.Operation.subtract;
        break;
      case STAR:
        jj_consume_token(STAR);
                  op = SymbolOperation.Operation.multiply;
        break;
      case SLASH:
        jj_consume_token(SLASH);
                   op = SymbolOperation.Operation.divide;
        break;
      default:
        jj_la1[34] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      ex2 = SymbolExpression();
      jj_consume_token(RBRACKET);
         {if (true) return new SymbolOperation(ex1, op, ex2);}
      break;
    default:
      jj_la1[35] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  public ParserTokenManager token_source;
  JavaCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[36];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
      jj_la1_0();
      jj_la1_1();
      jj_la1_2();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x400000,0x1800000,0x0,0x800000,0x0,0x80000000,0x2800000,0x800000,0x0,0x80000000,0x0,0x0,0x18000000,0x0,0x0,0x0,0x0,0x5f000000,0x5f000000,0x0,0x80000000,0x0,0x0,0x3000000,0x0,0x0,0x122000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x22000,};
   }
   private static void jj_la1_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x80,0x0,0x4,0x0,0x0,0x0,0x4,0x0,0x4,0x4,0x0,0x1000,0x1000,0x1000,0x1000,0x0,0x0,0x4,0x0,0x1,0x4,0x0,0x2,0x18008000,0x4,0x4,0x1000,0x20224,0x4000000,0x2000000,0x2020224,0x1e10000,0xe0000000,0x204,};
   }
   private static void jj_la1_2() {
      jj_la1_2 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x2,0x2,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x100000,0x1,0x0,};
   }

  public Parser(java.io.InputStream stream) {
     this(stream, null);
  }
  public Parser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 36; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 36; i++) jj_la1[i] = -1;
  }

  public Parser(java.io.Reader stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 36; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 36; i++) jj_la1[i] = -1;
  }

  public Parser(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 36; i++) jj_la1[i] = -1;
  }

  public void ReInit(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 36; i++) jj_la1[i] = -1;
  }

  final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.Vector jj_expentries = new java.util.Vector();
  private int[] jj_expentry;
  private int jj_kind = -1;

  public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[85];
    for (int i = 0; i < 85; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 36; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 85; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

    /*void jjtreeOpenNodeScope(Node n) {
	((ParseNode)n).firstToken = getToken(1);
    }

    void jjtreeCloseNodeScope(Node n) {
	((ParseNode)n).lastToken = getToken(0);
    }*/
}
