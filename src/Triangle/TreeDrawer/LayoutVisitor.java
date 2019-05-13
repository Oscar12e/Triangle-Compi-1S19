/*
 * @(#)LayoutVisitor.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.TreeDrawer;

import Triangle.AbstractSyntaxTrees.*;

import java.awt.*;

public class LayoutVisitor implements Visitor {

  private final int BORDER = 5;
  private final int PARENT_SEP = 30;

  private FontMetrics fontMetrics;

  public LayoutVisitor (FontMetrics fontMetrics) {
    this.fontMetrics = fontMetrics;
  }

  @Override
  public Object visitPackageDeclaration(PackageDeclaration ast, Object o) {
    return null;
  }

  @Override
  public Object visitSequentialPackageDeclaration(SequentialPackageDeclaration ast, Object o) {
    return null;
  }

  @Override
  public Object visitPackageIdentifier(PackageIdentifier ast, Object o) {
    return null;
  }

  // Commands
  public Object visitAssignCommand(AssignCommand ast, Object obj) {
    return layoutBinary("AssignCom.", ast.V, ast.E);
  }

  public Object visitCallCommand(CallCommand ast, Object obj) {
    return layoutBinary("CallCom.", ast.I, ast.APS);
   }

  public Object visitEmptyCommand(EmptyCommand ast, Object obj) {
    return layoutNullary("EmptyCom.");
  }

  public Object visitIfCommand(IfCommand ast, Object obj) {
    return layoutTernary("IfCom.", ast.E, ast.C1, ast.C2);
  }

  public Object visitLetCommand(LetCommand ast, Object obj) {
    return layoutBinary("LetCom.", ast.D, ast.C);
  }

  public Object visitSequentialCommand(SequentialCommand ast, Object obj) { return layoutBinary("Seq.Com.", ast.C1, ast.C2);
  }

  public Object visitWhileCommand(WhileCommand ast, Object obj) {
    return layoutBinary("WhileCom.", ast.E, ast.C);
  }

  @Override
  public Object visitDoWhileCommand(DoWhileCommand ast, Object o) {
    return layoutBinary("DoWhileCom.", ast.C, ast.E);
  }

  @Override
  public Object visitUntilCommand(UntilCommand ast, Object o) {
    return layoutBinary("UntilCom.", ast.E, ast.C);
  }

  @Override
  public Object visitDoUntilCommand(DoUntilCommand ast, Object o) {
    return layoutBinary("DoUntilCom.", ast.C, ast.E);
  }

  @Override
  public Object visitForCommand(ForCommand ast, Object o) {
    return layoutTernary("ForCom.", ast.F, ast.E, ast.C);
  }

  @Override
  public Object visitForWhileCommand(ForWhileCommand ast, Object o) {
    return layoutQuaternary("ForWhileCom.", ast.F, ast.E1, ast.E2, ast.C);
  }

  @Override
  public Object visitForUntilCommand(ForUntilCommand ast, Object o) {
    return layoutQuaternary("ForUntilCom.", ast.F, ast.E1, ast.E2, ast.C);
  }

  @Override
  public Object visitChooseCommand(ChooseCommand ast, Object o) {
    return null;
  }

  @Override
  public Object visitCase(Case ast, Object o) {
    return null;
  }

  @Override
  public Object visitElseCase(ElseCase ast, Object o) {
    return null;
  }

  @Override
  public Object visitSequentialCases(SequentialCases ast, Object o) {
    return null;
  }

  @Override
  public Object visitCaseLiterals(CaseLiterals ast, Object o) {
    return null;
  }

  @Override
  public Object visitSequentialCaseLiterals(SequentialCaseLiterals ast, Object o) {
    return null;
  }


  @Override
  public Object visitCaseRange(CaseRange ast, Object o) {
    return null;
  }

  @Override
  public Object visitCaseLiteral(CaseLiteral ast, Object o) {
    return null;
  }


  // Expressions
  public Object visitArrayExpression(ArrayExpression ast, Object obj) {
    return layoutUnary("ArrayExpr.", ast.AA);
  }

  public Object visitBinaryExpression(BinaryExpression ast, Object obj) {
    return layoutTernary("Bin.Expr.", ast.E1, ast.O, ast.E2);
  }

  public Object visitCallExpression(CallExpression ast, Object obj) {
    return layoutBinary("CallExpr.", ast.I, ast.APS);
  }

  public Object visitCharacterExpression(CharacterExpression ast, Object obj) {
    return layoutUnary("Char.Expr.", ast.CL);
  }

  public Object visitEmptyExpression(EmptyExpression ast, Object obj) {
    return layoutNullary("EmptyExpr.");
  }

  public Object visitIfExpression(IfExpression ast, Object obj) {
    return layoutTernary("IfExpr.", ast.E1, ast.E2, ast.E3);
  }

  public Object visitIntegerExpression(IntegerExpression ast, Object obj) {
    return layoutUnary("Int.Expr.", ast.IL);
  }

  public Object visitLetExpression(LetExpression ast, Object obj) {
    return layoutBinary("LetExpr.", ast.D, ast.E);
  }

  public Object visitRecordExpression(RecordExpression ast, Object obj) {
    return layoutUnary("Rec.Expr.", ast.RA);
  }

  public Object visitUnaryExpression(UnaryExpression ast, Object obj) {
    return layoutBinary("UnaryExpr.", ast.O, ast.E);
  }

  public Object visitVnameExpression(VnameExpression ast, Object obj) {
    return layoutUnary("VnameExpr.", ast.V);
  }


  // Declarations
  public Object visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Object obj) {
    return layoutQuaternary("Bin.Op.Decl.", ast.O, ast.ARG1, ast.ARG2, ast.RES);
  }

  public Object visitConstDeclaration(ConstDeclaration ast, Object obj) {
    return layoutBinary("ConstDecl.", ast.I, ast.E);
  }

  public Object visitFuncDeclaration(FuncDeclaration ast, Object obj) {
    return layoutQuaternary("FuncDecl.", ast.I, ast.FPS, ast.T, ast.E);
  }

  public Object visitProcDeclaration(ProcDeclaration ast, Object obj) {
    return layoutTernary("ProcDecl.", ast.I, ast.FPS, ast.C);
  }

  public Object visitSequentialDeclaration(SequentialDeclaration ast, Object obj) {
    return layoutBinary("Seq.Decl.", ast.D1, ast.D2);
  }

  public Object visitTypeDeclaration(TypeDeclaration ast, Object obj) {
    return layoutBinary("TypeDecl.", ast.I, ast.T);
  }

  public Object visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Object obj) {
    return layoutTernary("UnaryOp.Decl.", ast.O, ast.ARG, ast.RES);
  }

  public Object visitVarDeclaration(VarDeclaration ast, Object obj) {
    return layoutBinary("VarDecl.", ast.I, ast.T);
  }

  @Override
  public Object visitForDeclaration(ForDeclaration ast, Object o) {
    return layoutBinary("For.Decl.", ast.I, ast.E);
  }

  @Override
  public Object visitPrivateDeclaration(PrivateDeclaration ast, Object o) {
    return null;
  }

  @Override
  public Object visitParDeclaration(ParDeclaration ast, Object o) {
    return null;
  }

  @Override
  public Object visitRecursiveDeclaration(RecursiveDeclaration ast, Object o) {
    return null;
  }

  @Override
  public Object visitSequentialProcFuncs(SequentialProcFuncs ast, Object o) {
    return null;
  }

  @Override
  public Object visitRecursiveFunc(RecursiveFunc ast, Object o) {
    return null;
  }

  @Override
  public Object visitRecursiveFuncTwo(RecursiveFunc ast, Object o) {
    return null;
  }

  @Override
  public Object visitRecursiveProc(RecursiveProc ast, Object o) {
    return null;
  }

  @Override
  public Object visitRecursiveProcTwo(RecursiveProc ast, Object o) {
    return null;
  }

  @Override
  public Object visitInitializedDeclaration(InitializedDeclaration ast, Object o) {
    return null;
  }


  // Array Aggregates
  public Object visitMultipleArrayAggregate(MultipleArrayAggregate ast, Object obj) {
    return layoutBinary("Mult.ArrayAgg.", ast.E, ast.AA);
  }

  public Object visitSingleArrayAggregate(SingleArrayAggregate ast, Object obj) {
    return layoutUnary("Sing.ArrayAgg.", ast.E);
  }


  // Record Aggregates
  public Object visitMultipleRecordAggregate(MultipleRecordAggregate ast, Object obj) {
    return layoutTernary("Mult.Rec.Agg.", ast.I, ast.E, ast.RA);
  }

  public Object visitSingleRecordAggregate(SingleRecordAggregate ast, Object obj) {
    return layoutBinary("Sing.Rec.Agg.", ast.I, ast.E);
  }


  // Formal Parameters
  public Object visitConstFormalParameter(ConstFormalParameter ast, Object obj) {
    return layoutBinary("ConstF.P.", ast.I, ast.T);
  }

  public Object visitFuncFormalParameter(FuncFormalParameter ast, Object obj) {
    return layoutTernary("FuncF.P.", ast.I, ast.FPS, ast.T);
  }

  public Object visitProcFormalParameter(ProcFormalParameter ast, Object obj) {
    return layoutBinary("ProcF.P.", ast.I, ast.FPS);
  }

  public Object visitVarFormalParameter(VarFormalParameter ast, Object obj) {
    return layoutBinary("VarF.P.", ast.I, ast.T);
  }


  public Object visitEmptyFormalParameterSequence(EmptyFormalParameterSequence ast, Object obj) {
    return layoutNullary("EmptyF.P.S.");
  }

  public Object visitMultipleFormalParameterSequence(MultipleFormalParameterSequence ast, Object obj) {
    return layoutBinary("Mult.F.P.S.", ast.FP, ast.FPS);
  }

  public Object visitSingleFormalParameterSequence(SingleFormalParameterSequence ast, Object obj) {
    return layoutUnary("Sing.F.P.S.", ast.FP);
  }


  // Actual Parameters
  public Object visitConstActualParameter(ConstActualParameter ast, Object obj) {
    return layoutUnary("ConstA.P.", ast.E);
  }

  public Object visitFuncActualParameter(FuncActualParameter ast, Object obj) {
    return layoutUnary("FuncA.P.", ast.I);
  }

  public Object visitProcActualParameter(ProcActualParameter ast, Object obj) {
    return layoutUnary("ProcA.P.", ast.I);
  }

  public Object visitVarActualParameter(VarActualParameter ast, Object obj) {
    return layoutUnary("VarA.P.", ast.V);
  }


  public Object visitEmptyActualParameterSequence(EmptyActualParameterSequence ast, Object obj) {
    return layoutNullary("EmptyA.P.S.");
  }

  public Object visitMultipleActualParameterSequence(MultipleActualParameterSequence ast, Object obj) {
    return layoutBinary("Mult.A.P.S.", ast.AP, ast.APS);
  }

  public Object visitSingleActualParameterSequence(SingleActualParameterSequence ast, Object obj) {
    return layoutUnary("Sing.A.P.S.", ast.AP);
  }


  // Type Denoters
  public Object visitAnyTypeDenoter(AnyTypeDenoter ast, Object obj) {
    return layoutNullary("any");
  }

  public Object visitArrayTypeDenoter(ArrayTypeDenoter ast, Object obj) {
    return layoutBinary("ArrayTypeD.", ast.IL, ast.T);
  }

  public Object visitBoolTypeDenoter(BoolTypeDenoter ast, Object obj) {
    return layoutNullary("bool");
  }

  public Object visitCharTypeDenoter(CharTypeDenoter ast, Object obj) {
    return layoutNullary("char");
  }

  public Object visitErrorTypeDenoter(ErrorTypeDenoter ast, Object obj) {
    return layoutNullary("error");
  }

  public Object visitSimpleTypeDenoter(SimpleTypeDenoter ast, Object obj) {
    return layoutUnary("Sim.TypeD.", ast.I);
  }

  public Object visitIntTypeDenoter(IntTypeDenoter ast, Object obj) {
    return layoutNullary("int");
  }

  public Object visitRecordTypeDenoter(RecordTypeDenoter ast, Object obj) {
    return layoutUnary("Rec.TypeD.", ast.FT);
  }


  public Object visitMultipleFieldTypeDenoter(MultipleFieldTypeDenoter ast, Object obj) {
    return layoutTernary("Mult.F.TypeD.", ast.I, ast.T, ast.FT);
  }

  public Object visitSingleFieldTypeDenoter(SingleFieldTypeDenoter ast, Object obj) {
    return layoutBinary("Sing.F.TypeD.", ast.I, ast.T);
  }


  // Literals, Identifiers and Operators
  public Object visitCharacterLiteral(CharacterLiteral ast, Object obj) {
    return layoutNullary(ast.spelling);
  }

  public Object visitIdentifier(Identifier ast, Object obj) {
    return layoutNullary(ast.spelling);
 }

  public Object visitIntegerLiteral(IntegerLiteral ast, Object obj) {
    return layoutNullary(ast.spelling);
  }

  public Object visitOperator(Operator ast, Object obj) {
    return layoutNullary(ast.spelling);
  }

  @Override
  public Object visitLongIdentifier(LongIdentifier ast, Object o) {
    return null;
  }

  // Value-or-variable names
  public Object visitDotVname(DotVname ast, Object obj) {
    return layoutBinary("DotVname", ast.I, ast.V);
  }

  public Object visitSimpleVname(SimpleVname ast, Object obj) {
    return layoutUnary("Sim.Vname", ast.I);
  }

  public Object visitSubscriptVname(SubscriptVname ast, Object obj) { return layoutBinary("Sub.Vname", ast.V, ast.E); }


  // Programs
  public Object visitProgram(Program ast, Object obj) {
    if (ast instanceof SimpleProgram){
      SimpleProgram pAST = (SimpleProgram) ast;
      return visitSimpleProgram(pAST, obj);
    } else {
      PackagedProgram pAST = (PackagedProgram) ast;
      return visitPackagedProgram(pAST, obj);
    }
  }

  @Override
  public Object visitSimpleProgram(SimpleProgram ast, Object o) {
    return layoutUnary("Program", ast.C);
  }

  @Override
  public Object visitPackagedProgram(PackagedProgram ast, Object o) { return layoutBinary("Packaged Program", ast.P, ast.C); }

  @Override
  public Object visitSequentialProcFuncsTwo(SequentialProcFuncs ast, Object o) {
    return null;
  }

  private DrawingTree layoutCaption (String name) {
    int w = fontMetrics.stringWidth(name) + 4;
    int h = fontMetrics.getHeight() + 4;
    return new DrawingTree(name, w, h);
  }

  private DrawingTree layoutNullary (String name) {
    DrawingTree dt = layoutCaption(name);
    dt.contour.upper_tail = new Polyline(0, dt.height + 2 * BORDER, null);
    dt.contour.upper_head = dt.contour.upper_tail;
    dt.contour.lower_tail = new Polyline(-dt.width - 2 * BORDER, 0, null);
    dt.contour.lower_head = new Polyline(0, dt.height + 2 * BORDER, dt.contour.lower_tail);
    return dt;
  }

  private DrawingTree layoutUnary (String name, AST child1) {
    DrawingTree dt = layoutCaption(name);
    DrawingTree d1 = (DrawingTree) child1.visit(this, null);
    dt.setChildren(new DrawingTree[] {d1});
    attachParent(dt, join(dt));
    return dt;
  }

  private DrawingTree layoutBinary (String name, AST child1, AST child2) {
    DrawingTree dt = layoutCaption(name);
    DrawingTree d1 = (DrawingTree) child1.visit(this, null);
    DrawingTree d2 = (DrawingTree) child2.visit(this, null);
    dt.setChildren(new DrawingTree[] {d1, d2});
    attachParent(dt, join(dt));
    return dt;
  }

  private DrawingTree layoutTernary (String name, AST child1, AST child2,
                                     AST child3) {
    DrawingTree dt = layoutCaption(name);
    DrawingTree d1 = (DrawingTree) child1.visit(this, null);
    DrawingTree d2 = (DrawingTree) child2.visit(this, null);
    DrawingTree d3 = (DrawingTree) child3.visit(this, null);
    dt.setChildren(new DrawingTree[] {d1, d2, d3});
    attachParent(dt, join(dt));
    return dt;
  }

  private DrawingTree layoutQuaternary (String name, AST child1, AST child2,
                                        AST child3, AST child4) {
    DrawingTree dt = layoutCaption(name);
    DrawingTree d1 = (DrawingTree) child1.visit(this, null);
    DrawingTree d2 = (DrawingTree) child2.visit(this, null);
    DrawingTree d3 = (DrawingTree) child3.visit(this, null);
    DrawingTree d4 = (DrawingTree) child4.visit(this, null);
    dt.setChildren(new DrawingTree[] {d1, d2, d3, d4});
    attachParent(dt, join(dt));
    return dt;
  }

  private void attachParent(DrawingTree dt, int w) {
    int y = PARENT_SEP;
    int x2 = (w - dt.width) / 2 - BORDER;
    int x1 = x2 + dt.width + 2 * BORDER - w;

    dt.children[0].offset.y = y + dt.height;
    dt.children[0].offset.x = x1;
    dt.contour.upper_head = new Polyline(0, dt.height,
                                new Polyline(x1, y, dt.contour.upper_head));
    dt.contour.lower_head = new Polyline(0, dt.height,
                                new Polyline(x2, y, dt.contour.lower_head));
  }

  private int join (DrawingTree dt) {
    int w, sum;

    dt.contour = dt.children[0].contour;
    sum = w = dt.children[0].width + 2 * BORDER;

    for (int i = 1; i < dt.children.length; i++) {
      int d = merge(dt.contour, dt.children[i].contour);
      dt.children[i].offset.x = d + w;
      dt.children[i].offset.y = 0;
      w = dt.children[i].width + 2 * BORDER;
      sum += d + w;
    }
    return sum;
  }

  private int merge(Polygon c1, Polygon c2) {
    int x, y, total, d;
    Polyline lower, upper, b;

    x = y = total = 0;
    upper = c1.lower_head;
    lower = c2.upper_head;

    while (lower != null && upper != null) {
        d = offset(x, y, lower.dx, lower.dy, upper.dx, upper.dy);
	x += d;
	total += d;

	if (y + lower.dy <= upper.dy) {
	  x += lower.dx;
	  y += lower.dy;
	  lower = lower.link;
	} else {
	  x -= upper.dx;
	  y -= upper.dy;
	  upper = upper.link;
	}
      }

      if (lower != null) {
        b = bridge(c1.upper_tail, 0, 0, lower, x, y);
        c1.upper_tail = (b.link != null) ? c2.upper_tail : b;
        c1.lower_tail = c2.lower_tail;
      } else {
        b = bridge(c2.lower_tail, x, y, upper, 0, 0);
        if (b.link == null) {
          c1.lower_tail = b;
        }
      }

      c1.lower_head = c2.lower_head;

      return total;
    }

  private int offset (int p1, int p2, int a1, int a2, int b1, int b2) {
    int d, s, t;

    if (b2 <= p2 || p2 + a2 <= 0) {
      return 0;
    }

    t = b2 * a1 - a2 * b1;
    if (t > 0) {
      if (p2 < 0) {
        s = p2 * a1;
        d = s / a2 - p1;
      } else if (p2 > 0) {
        s = p2 * b1;
        d = s / b2 - p1;
      } else {
        d = -p1;
      }
    } else if (b2 < p2 + a2) {
      s = (b2 - p2) * a1;
      d = b1 - (p1 + s / a2);
    } else if (b2 > p2 + a2) {
      s = (a2 + p2) * b1;
      d = s / b2 - (p1 + a1);
    } else {
      d = b1 - (p1 + a1);
    }

    if (d > 0) {
      return d;
    } else {
      return 0;
    }
  }

  private Polyline bridge (Polyline line1, int x1, int y1,
                           Polyline line2, int x2, int y2) {
    int dy, dx, s;
    Polyline r;

    dy = y2 + line2.dy - y1;
    if (line2.dy == 0) {
      dx = line2.dx;
    } else {
      s = dy * line2.dx;
      dx = s / line2.dy;
    }

    r = new Polyline(dx, dy, line2.link);
    line1.link = new Polyline(x2 + line2.dx - dx - x1, 0, r);

    return r;
  }

}