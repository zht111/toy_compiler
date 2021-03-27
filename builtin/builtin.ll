; ModuleID = 'builtin.c'
source_filename = "builtin.c"
target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

@.str = private unnamed_addr constant [3 x i8] c"%s\00", align 1
@.str.2 = private unnamed_addr constant [3 x i8] c"%d\00", align 1
@.str.3 = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1

; Function Attrs: nofree nounwind uwtable
define dso_local void @builtin_print(i8* %0) local_unnamed_addr #0 {
  %2 = tail call i32 (i8*, ...) @printf(i8* nonnull dereferenceable(1) getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0, i64 0), i8* %0)
  ret void
}

; Function Attrs: nofree nounwind
declare dso_local i32 @printf(i8* nocapture readonly, ...) local_unnamed_addr #1

; Function Attrs: nofree nounwind uwtable
define dso_local void @builtin_println(i8* nocapture readonly %0) local_unnamed_addr #0 {
  %2 = tail call i32 @puts(i8* nonnull dereferenceable(1) %0)
  ret void
}

; Function Attrs: nofree nounwind uwtable
define dso_local void @builtin_printInt(i32 %0) local_unnamed_addr #0 {
  %2 = tail call i32 (i8*, ...) @printf(i8* nonnull dereferenceable(1) getelementptr inbounds ([3 x i8], [3 x i8]* @.str.2, i64 0, i64 0), i32 %0)
  ret void
}

; Function Attrs: nofree nounwind uwtable
define dso_local void @builtin_printlnInt(i32 %0) local_unnamed_addr #0 {
  %2 = tail call i32 (i8*, ...) @printf(i8* nonnull dereferenceable(1) getelementptr inbounds ([4 x i8], [4 x i8]* @.str.3, i64 0, i64 0), i32 %0)
  ret void
}

; Function Attrs: nofree nounwind uwtable
define dso_local i8* @builtin_getString() local_unnamed_addr #0 {
  %1 = tail call noalias dereferenceable_or_null(1000) i8* @malloc(i64 1000) #9
  %2 = tail call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0, i64 0), i8* %1)
  ret i8* %1
}

; Function Attrs: argmemonly nounwind willreturn
declare void @llvm.lifetime.start.p0i8(i64 immarg, i8* nocapture) #2

; Function Attrs: nofree nounwind
declare dso_local noalias i8* @malloc(i64) local_unnamed_addr #1

; Function Attrs: nofree nounwind
declare dso_local i32 @__isoc99_scanf(i8* nocapture readonly, ...) local_unnamed_addr #1

; Function Attrs: argmemonly nounwind willreturn
declare void @llvm.lifetime.end.p0i8(i64 immarg, i8* nocapture) #2

; Function Attrs: nounwind uwtable
define dso_local i32 @builtin_getInt() local_unnamed_addr #3 {
  %1 = alloca i32, align 4
  %2 = bitcast i32* %1 to i8*
  call void @llvm.lifetime.start.p0i8(i64 4, i8* nonnull %2) #9
  %3 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.2, i64 0, i64 0), i32* nonnull %1)
  %4 = load i32, i32* %1, align 4, !tbaa !2
  call void @llvm.lifetime.end.p0i8(i64 4, i8* nonnull %2) #9
  ret i32 %4
}

; Function Attrs: nounwind uwtable
define dso_local noalias i8* @builtin_toString(i32 %0) local_unnamed_addr #3 {
  %2 = alloca [10 x i16], align 16
  %3 = icmp eq i32 %0, 0
  br i1 %3, label %4, label %7

4:                                                ; preds = %1
  %5 = tail call noalias dereferenceable_or_null(2) i8* @malloc(i64 2) #9
  store i8 48, i8* %5, align 1, !tbaa !6
  %6 = getelementptr inbounds i8, i8* %5, i64 1
  store i8 0, i8* %6, align 1, !tbaa !6
  br label %128

7:                                                ; preds = %1
  %8 = bitcast [10 x i16]* %2 to i8*
  call void @llvm.lifetime.start.p0i8(i64 20, i8* nonnull %8) #9
  %9 = lshr i32 %0, 31
  %10 = icmp slt i32 %0, 0
  %11 = sub nsw i32 0, %0
  %12 = select i1 %10, i32 %11, i32 %0
  %13 = icmp eq i32 %12, 0
  br i1 %13, label %24, label %14

14:                                               ; preds = %7, %14
  %15 = phi i16 [ %19, %14 ], [ 0, %7 ]
  %16 = phi i32 [ %22, %14 ], [ %12, %7 ]
  %17 = urem i32 %16, 10
  %18 = trunc i32 %17 to i16
  %19 = add i16 %15, 1
  %20 = sext i16 %15 to i64
  %21 = getelementptr inbounds [10 x i16], [10 x i16]* %2, i64 0, i64 %20
  store i16 %18, i16* %21, align 2, !tbaa !7
  %22 = udiv i32 %16, 10
  %23 = icmp ult i32 %16, 10
  br i1 %23, label %24, label %14

24:                                               ; preds = %14, %7
  %25 = phi i16 [ 0, %7 ], [ %19, %14 ]
  %26 = sext i16 %25 to i32
  %27 = add nsw i32 %9, %26
  %28 = add nsw i32 %27, 1
  %29 = sext i32 %28 to i64
  %30 = tail call noalias i8* @malloc(i64 %29) #9
  br i1 %10, label %31, label %32

31:                                               ; preds = %24
  store i8 45, i8* %30, align 1, !tbaa !6
  br label %32

32:                                               ; preds = %31, %24
  %33 = icmp sgt i16 %25, 0
  br i1 %33, label %34, label %125

34:                                               ; preds = %32
  %35 = zext i32 %9 to i64
  %36 = zext i16 %25 to i64
  %37 = icmp ult i16 %25, 16
  br i1 %37, label %77, label %38

38:                                               ; preds = %34
  %39 = add nsw i64 %36, -1
  %40 = trunc i64 %39 to i32
  %41 = xor i32 %40, -1
  %42 = add i32 %41, %26
  %43 = icmp sge i32 %42, %26
  %44 = icmp ugt i64 %39, 4294967295
  %45 = or i1 %43, %44
  br i1 %45, label %77, label %46

46:                                               ; preds = %38
  %47 = and i64 %36, 65520
  %48 = trunc i64 %47 to i32
  br label %49

49:                                               ; preds = %49, %46
  %50 = phi i64 [ 0, %46 ], [ %73, %49 ]
  %51 = trunc i64 %50 to i32
  %52 = xor i32 %51, -1
  %53 = add nsw i32 %52, %26
  %54 = sext i32 %53 to i64
  %55 = getelementptr inbounds [10 x i16], [10 x i16]* %2, i64 0, i64 %54
  %56 = getelementptr inbounds i16, i16* %55, i64 -7
  %57 = bitcast i16* %56 to <8 x i16>*
  %58 = load <8 x i16>, <8 x i16>* %57, align 2, !tbaa !7
  %59 = shufflevector <8 x i16> %58, <8 x i16> undef, <8 x i32> <i32 7, i32 6, i32 5, i32 4, i32 3, i32 2, i32 1, i32 0>
  %60 = getelementptr inbounds i16, i16* %55, i64 -15
  %61 = bitcast i16* %60 to <8 x i16>*
  %62 = load <8 x i16>, <8 x i16>* %61, align 2, !tbaa !7
  %63 = shufflevector <8 x i16> %62, <8 x i16> undef, <8 x i32> <i32 7, i32 6, i32 5, i32 4, i32 3, i32 2, i32 1, i32 0>
  %64 = trunc <8 x i16> %59 to <8 x i8>
  %65 = trunc <8 x i16> %63 to <8 x i8>
  %66 = add <8 x i8> %64, <i8 48, i8 48, i8 48, i8 48, i8 48, i8 48, i8 48, i8 48>
  %67 = add <8 x i8> %65, <i8 48, i8 48, i8 48, i8 48, i8 48, i8 48, i8 48, i8 48>
  %68 = or i64 %50, %35
  %69 = getelementptr inbounds i8, i8* %30, i64 %68
  %70 = bitcast i8* %69 to <8 x i8>*
  store <8 x i8> %66, <8 x i8>* %70, align 1, !tbaa !6
  %71 = getelementptr inbounds i8, i8* %69, i64 8
  %72 = bitcast i8* %71 to <8 x i8>*
  store <8 x i8> %67, <8 x i8>* %72, align 1, !tbaa !6
  %73 = add i64 %50, 16
  %74 = icmp eq i64 %73, %47
  br i1 %74, label %75, label %49, !llvm.loop !9

75:                                               ; preds = %49
  %76 = icmp eq i64 %47, %36
  br i1 %76, label %125, label %77

77:                                               ; preds = %75, %38, %34
  %78 = phi i32 [ 0, %38 ], [ 0, %34 ], [ %48, %75 ]
  %79 = phi i64 [ 0, %38 ], [ 0, %34 ], [ %47, %75 ]
  %80 = xor i64 %79, -1
  %81 = and i64 %36, 1
  %82 = icmp eq i64 %81, 0
  br i1 %82, label %95, label %83

83:                                               ; preds = %77
  %84 = xor i32 %78, -1
  %85 = add nsw i32 %84, %26
  %86 = sext i32 %85 to i64
  %87 = getelementptr inbounds [10 x i16], [10 x i16]* %2, i64 0, i64 %86
  %88 = load i16, i16* %87, align 2, !tbaa !7
  %89 = trunc i16 %88 to i8
  %90 = add i8 %89, 48
  %91 = or i64 %79, %35
  %92 = getelementptr inbounds i8, i8* %30, i64 %91
  store i8 %90, i8* %92, align 1, !tbaa !6
  %93 = or i64 %79, 1
  %94 = add nuw nsw i32 %78, 1
  br label %95

95:                                               ; preds = %77, %83
  %96 = phi i32 [ %78, %77 ], [ %94, %83 ]
  %97 = phi i64 [ %79, %77 ], [ %93, %83 ]
  %98 = sub nsw i64 0, %36
  %99 = icmp eq i64 %80, %98
  br i1 %99, label %125, label %100

100:                                              ; preds = %95, %100
  %101 = phi i32 [ %123, %100 ], [ %96, %95 ]
  %102 = phi i64 [ %122, %100 ], [ %97, %95 ]
  %103 = xor i32 %101, -1
  %104 = add nsw i32 %103, %26
  %105 = sext i32 %104 to i64
  %106 = getelementptr inbounds [10 x i16], [10 x i16]* %2, i64 0, i64 %105
  %107 = load i16, i16* %106, align 2, !tbaa !7
  %108 = trunc i16 %107 to i8
  %109 = add i8 %108, 48
  %110 = add nuw nsw i64 %102, %35
  %111 = getelementptr inbounds i8, i8* %30, i64 %110
  store i8 %109, i8* %111, align 1, !tbaa !6
  %112 = add nuw nsw i64 %102, 1
  %113 = sub i32 -2, %101
  %114 = add nsw i32 %113, %26
  %115 = sext i32 %114 to i64
  %116 = getelementptr inbounds [10 x i16], [10 x i16]* %2, i64 0, i64 %115
  %117 = load i16, i16* %116, align 2, !tbaa !7
  %118 = trunc i16 %117 to i8
  %119 = add i8 %118, 48
  %120 = add nuw nsw i64 %112, %35
  %121 = getelementptr inbounds i8, i8* %30, i64 %120
  store i8 %119, i8* %121, align 1, !tbaa !6
  %122 = add nuw nsw i64 %102, 2
  %123 = add nuw nsw i32 %101, 2
  %124 = icmp eq i64 %122, %36
  br i1 %124, label %125, label %100, !llvm.loop !11

125:                                              ; preds = %95, %100, %75, %32
  %126 = sext i32 %27 to i64
  %127 = getelementptr inbounds i8, i8* %30, i64 %126
  store i8 0, i8* %127, align 1, !tbaa !6
  call void @llvm.lifetime.end.p0i8(i64 20, i8* nonnull %8) #9
  br label %128

128:                                              ; preds = %125, %4
  %129 = phi i8* [ %5, %4 ], [ %30, %125 ]
  ret i8* %129
}

; Function Attrs: nounwind readonly uwtable
define dso_local i32 @l_string_length(i8* nocapture readonly %0) local_unnamed_addr #4 {
  %2 = tail call i64 @strlen(i8* nonnull dereferenceable(1) %0) #10
  %3 = trunc i64 %2 to i32
  ret i32 %3
}

; Function Attrs: argmemonly nofree nounwind readonly
declare dso_local i64 @strlen(i8* nocapture) local_unnamed_addr #5

; Function Attrs: nounwind uwtable
define dso_local noalias i8* @l_string_substring(i8* nocapture readonly %0, i32 %1, i32 %2) local_unnamed_addr #3 {
  %4 = tail call noalias dereferenceable_or_null(1000) i8* @malloc(i64 1000) #9
  %5 = sext i32 %1 to i64
  %6 = getelementptr inbounds i8, i8* %0, i64 %5
  %7 = sub nsw i32 %2, %1
  %8 = sext i32 %7 to i64
  tail call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %4, i8* align 1 %6, i64 %8, i1 false)
  ret i8* %4
}

; Function Attrs: argmemonly nounwind willreturn
declare void @llvm.memcpy.p0i8.p0i8.i64(i8* noalias nocapture writeonly, i8* noalias nocapture readonly, i64, i1 immarg) #2

; Function Attrs: nounwind uwtable
define dso_local i32 @l_string_parseInt(i8* nocapture readonly %0) local_unnamed_addr #3 {
  %2 = alloca i32, align 4
  %3 = bitcast i32* %2 to i8*
  call void @llvm.lifetime.start.p0i8(i64 4, i8* nonnull %3) #9
  %4 = call i32 (i8*, i8*, ...) @__isoc99_sscanf(i8* %0, i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.2, i64 0, i64 0), i32* nonnull %2) #9
  %5 = load i32, i32* %2, align 4, !tbaa !2
  call void @llvm.lifetime.end.p0i8(i64 4, i8* nonnull %3) #9
  ret i32 %5
}

; Function Attrs: nofree nounwind
declare dso_local i32 @__isoc99_sscanf(i8* nocapture readonly, i8* nocapture readonly, ...) local_unnamed_addr #1

; Function Attrs: norecurse nounwind readonly uwtable
define dso_local i32 @l_string_ord(i8* nocapture readonly %0, i32 %1) local_unnamed_addr #6 {
  %3 = sext i32 %1 to i64
  %4 = getelementptr inbounds i8, i8* %0, i64 %3
  %5 = load i8, i8* %4, align 1, !tbaa !6
  %6 = sext i8 %5 to i32
  ret i32 %6
}

; Function Attrs: nounwind uwtable
define dso_local i8* @builtin_stringAdd(i8* nocapture readonly %0, i8* nocapture readonly %1) local_unnamed_addr #3 {
  %3 = tail call noalias dereferenceable_or_null(1000) i8* @malloc(i64 1000) #9
  %4 = tail call i64 @strlen(i8* nonnull dereferenceable(1) %0) #10
  %5 = shl i64 %4, 32
  %6 = ashr exact i64 %5, 32
  tail call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %3, i8* align 1 %0, i64 %6, i1 false)
  %7 = getelementptr inbounds i8, i8* %3, i64 %6
  store i8 0, i8* %7, align 1, !tbaa !6
  %8 = tail call i8* @strcat(i8* nonnull dereferenceable(1) %3, i8* nonnull dereferenceable(1) %1) #9
  ret i8* %3
}

; Function Attrs: nofree nounwind
declare dso_local i8* @strcat(i8* returned, i8* nocapture readonly) local_unnamed_addr #1

; Function Attrs: nounwind readonly uwtable
define dso_local i32 @builtin_stringLT(i8* nocapture readonly %0, i8* nocapture readonly %1) local_unnamed_addr #4 {
  %3 = tail call i32 @strcmp(i8* nonnull dereferenceable(1) %0, i8* nonnull dereferenceable(1) %1) #10
  %4 = lshr i32 %3, 31
  ret i32 %4
}

; Function Attrs: nofree nounwind readonly
declare dso_local i32 @strcmp(i8* nocapture, i8* nocapture) local_unnamed_addr #7

; Function Attrs: nounwind readonly uwtable
define dso_local i32 @builtin_stringGT(i8* nocapture readonly %0, i8* nocapture readonly %1) local_unnamed_addr #4 {
  %3 = tail call i32 @strcmp(i8* nonnull dereferenceable(1) %0, i8* nonnull dereferenceable(1) %1) #10
  %4 = icmp sgt i32 %3, 0
  %5 = zext i1 %4 to i32
  ret i32 %5
}

; Function Attrs: nounwind readonly uwtable
define dso_local i32 @builtin_stringLE(i8* nocapture readonly %0, i8* nocapture readonly %1) local_unnamed_addr #4 {
  %3 = tail call i32 @strcmp(i8* nonnull dereferenceable(1) %0, i8* nonnull dereferenceable(1) %1) #10
  %4 = icmp slt i32 %3, 1
  %5 = zext i1 %4 to i32
  ret i32 %5
}

; Function Attrs: nounwind readonly uwtable
define dso_local i32 @builtin_stringGE(i8* nocapture readonly %0, i8* nocapture readonly %1) local_unnamed_addr #4 {
  %3 = tail call i32 @strcmp(i8* nonnull dereferenceable(1) %0, i8* nonnull dereferenceable(1) %1) #10
  %4 = lshr i32 %3, 31
  %5 = xor i32 %4, 1
  ret i32 %5
}

; Function Attrs: nounwind readonly uwtable
define dso_local i32 @builtin_stringEQ(i8* nocapture readonly %0, i8* nocapture readonly %1) local_unnamed_addr #4 {
  %3 = tail call i32 @strcmp(i8* nonnull dereferenceable(1) %0, i8* nonnull dereferenceable(1) %1) #10
  %4 = icmp eq i32 %3, 0
  %5 = zext i1 %4 to i32
  ret i32 %5
}

; Function Attrs: nounwind readonly uwtable
define dso_local i32 @builtin_stringNE(i8* nocapture readonly %0, i8* nocapture readonly %1) local_unnamed_addr #4 {
  %3 = tail call i32 @strcmp(i8* nonnull dereferenceable(1) %0, i8* nonnull dereferenceable(1) %1) #10
  %4 = icmp ne i32 %3, 0
  %5 = zext i1 %4 to i32
  ret i32 %5
}

; Function Attrs: nofree nounwind
declare i32 @puts(i8* nocapture readonly) local_unnamed_addr #8

attributes #0 = { nofree nounwind uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="none" "less-precise-fpmad"="false" "min-legal-vector-width"="0" "no-infs-fp-math"="true" "no-jump-tables"="false" "no-nans-fp-math"="true" "no-signed-zeros-fp-math"="true" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="true" "use-soft-float"="false" }
attributes #1 = { nofree nounwind "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="none" "less-precise-fpmad"="false" "no-infs-fp-math"="true" "no-nans-fp-math"="true" "no-signed-zeros-fp-math"="true" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="true" "use-soft-float"="false" }
attributes #2 = { argmemonly nounwind willreturn }
attributes #3 = { nounwind uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="none" "less-precise-fpmad"="false" "min-legal-vector-width"="0" "no-infs-fp-math"="true" "no-jump-tables"="false" "no-nans-fp-math"="true" "no-signed-zeros-fp-math"="true" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="true" "use-soft-float"="false" }
attributes #4 = { nounwind readonly uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="none" "less-precise-fpmad"="false" "min-legal-vector-width"="0" "no-infs-fp-math"="true" "no-jump-tables"="false" "no-nans-fp-math"="true" "no-signed-zeros-fp-math"="true" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="true" "use-soft-float"="false" }
attributes #5 = { argmemonly nofree nounwind readonly "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="none" "less-precise-fpmad"="false" "no-infs-fp-math"="true" "no-nans-fp-math"="true" "no-signed-zeros-fp-math"="true" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="true" "use-soft-float"="false" }
attributes #6 = { norecurse nounwind readonly uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="none" "less-precise-fpmad"="false" "min-legal-vector-width"="0" "no-infs-fp-math"="true" "no-jump-tables"="false" "no-nans-fp-math"="true" "no-signed-zeros-fp-math"="true" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="true" "use-soft-float"="false" }
attributes #7 = { nofree nounwind readonly "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="none" "less-precise-fpmad"="false" "no-infs-fp-math"="true" "no-nans-fp-math"="true" "no-signed-zeros-fp-math"="true" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="true" "use-soft-float"="false" }
attributes #8 = { nofree nounwind }
attributes #9 = { nounwind }
attributes #10 = { nounwind readonly }

!llvm.module.flags = !{!0}
!llvm.ident = !{!1}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{!"clang version 10.0.0-4ubuntu1 "}
!2 = !{!3, !3, i64 0}
!3 = !{!"int", !4, i64 0}
!4 = !{!"omnipotent char", !5, i64 0}
!5 = !{!"Simple C/C++ TBAA"}
!6 = !{!4, !4, i64 0}
!7 = !{!8, !8, i64 0}
!8 = !{!"short", !4, i64 0}
!9 = distinct !{!9, !10}
!10 = !{!"llvm.loop.isvectorized", i32 1}
!11 = distinct !{!11, !10}
