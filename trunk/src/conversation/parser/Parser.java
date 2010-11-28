/* Generated By:JJTree&JavaCC: Do not edit this line. Parser.java */
package conversation.parser;

public class Parser/*@bgen(jjtree)*/implements ParserTreeConstants, ParserConstants {/*@bgen(jjtree)*/
  protected JJTParserState jjtree = new JJTParserState();
    void jjtreeOpenNodeScope(Node n) {
        ((ParseNode)n).firstToken = getToken(1);
    }

    void jjtreeCloseNodeScope(Node n) {
        ((ParseNode)n).lastToken = getToken(0);
    }

/****************************************
 *  The Conversation Language Grammar starts here  *
 ****************************************/
  final public ASTConversationTopLevel ConversationTopLevel() throws ParseException {
                                                                        /*@bgen(jjtree) ConversationTopLevel */
    ASTConversationTopLevel jjtn000 = new ASTConversationTopLevel(this, JJTCONVERSATIONTOPLEVEL);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);Token t;
    ASTTopicNode topic;
    try {
      jj_consume_token(CONVERSATION);
      t = jj_consume_token(IDENTIFIER);
                                     jjtn000.setName(t.image);
      jj_consume_token(SEMICOLON);
      label_1:
      while (true) {
        jj_consume_token(PARTICIPANT);
        t = jj_consume_token(IDENTIFIER);
                                     jjtn000.addParticipant(t.image);
        jj_consume_token(SEMICOLON);
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
                           jjtn000.addTopic(topic);
      }
      jj_consume_token(0);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtreeCloseNodeScope(jjtn000);
     {if (true) return jjtn000;}
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
        jjtreeCloseNodeScope(jjtn000);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public ASTTopicNode TopicNode() throws ParseException {
                                       /*@bgen(jjtree) TopicNode */
    ASTTopicNode jjtn000 = new ASTTopicNode(this, JJTTOPICNODE);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);Token t;
    ASTBeatNode beat;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STARTING:
        jj_consume_token(STARTING);
                 jjtn000.setStarting(true);
        break;
      default:
        jj_la1[2] = jj_gen;
        ;
      }
      jj_consume_token(TOPIC);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        t = jj_consume_token(IDENTIFIER);
                                                                         jjtn000.setName(t.image);
        break;
      default:
        jj_la1[3] = jj_gen;
        ;
      }
      jj_consume_token(LBRACE);
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case STARTING:
        case BEAT:
          ;
          break;
        default:
          jj_la1[4] = jj_gen;
          break label_3;
        }
        beat = BeatNode();
                         jjtn000.addBeat(beat);
      }
      jj_consume_token(RBRACE);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtreeCloseNodeScope(jjtn000);
     {if (true) return jjtn000;}
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
        jjtreeCloseNodeScope(jjtn000);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public ASTBeatNode BeatNode() throws ParseException {
                                    /*@bgen(jjtree) BeatNode */
    ASTBeatNode jjtn000 = new ASTBeatNode(this, JJTBEATNODE);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);Token t;
    ASTGroupNode root;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STARTING:
        jj_consume_token(STARTING);
                 jjtn000.setStarting(true);
        break;
      default:
        jj_la1[5] = jj_gen;
        ;
      }
      jj_consume_token(BEAT);
      root = GroupNode();
                        jjtn000.setRoot(root);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtreeCloseNodeScope(jjtn000);
     {if (true) return jjtn000;}
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
        jjtreeCloseNodeScope(jjtn000);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public ASTGroupNode GroupNode() throws ParseException {
                                       /*@bgen(jjtree) GroupNode */
    ASTGroupNode jjtn000 = new ASTGroupNode(this, JJTGROUPNODE);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);Token t;
    ASTLeafNode leaf;
    ASTGroupNode group;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SEQ:
        t = jj_consume_token(SEQ);
        break;
      case OP:
        t = jj_consume_token(OP);
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
                            jjtn000.setType(t.image);
      jj_consume_token(LBRACE);
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case NODE:
          leaf = LeafNode();
                           jjtn000.addLeaf(leaf);
          break;
        case OP:
        case SEQ:
          group = GroupNode();
                               jjtn000.addGroup(group);
          break;
        case BEAT:
          jj_consume_token(BEAT);
          jj_consume_token(BREAK);
                          jjtn000.addBeatBreak();
          break;
        case TOPIC:
          jj_consume_token(TOPIC);
          jj_consume_token(BREAK);
                           jjtn000.addTopicBreak();
          break;
        default:
          jj_la1[7] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case TOPIC:
        case BEAT:
        case NODE:
        case OP:
        case SEQ:
          ;
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_4;
        }
      }
      jj_consume_token(RBRACE);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtreeCloseNodeScope(jjtn000);
     {if (true) return jjtn000;}
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
        jjtreeCloseNodeScope(jjtn000);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public ASTLeafNode LeafNode() throws ParseException {
                                    /*@bgen(jjtree) LeafNode */
    ASTLeafNode jjtn000 = new ASTLeafNode(this, JJTLEAFNODE);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    jjtreeOpenNodeScope(jjtn000);Token t;
    try {
      jj_consume_token(NODE);
      jj_consume_token(LBRACE);
      t = jj_consume_token(IDENTIFIER);
                      jjtn000.setSpeaker(t.image);
      jj_consume_token(COMMA);
      t = jj_consume_token(STRING_LITERAL);
                          jjtn000.setContent(t.image);
      jj_consume_token(RBRACE);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtreeCloseNodeScope(jjtn000);
     {if (true) return jjtn000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
        jjtreeCloseNodeScope(jjtn000);
      }
    }
    throw new Error("Missing return statement in function");
  }

  public ParserTokenManager token_source;
  JavaCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[9];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
      jj_la1_0();
      jj_la1_1();
      jj_la1_2();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x400000,0x1800000,0x800000,0x40000000,0x2800000,0x800000,0x18000000,0x1f000000,0x1f000000,};
   }
   private static void jj_la1_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_2() {
      jj_la1_2 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
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
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  public Parser(java.io.Reader stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  public Parser(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  public void ReInit(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[81];
    for (int i = 0; i < 81; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 9; i++) {
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
    for (int i = 0; i < 81; i++) {
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

}
