#include <stdint.h>
#include <stdlib.h>

#include <algorithm>

#include "ortools/base/logging.h"
#include "ortools/sat/cp_model.h"
#include "ortools/sat/cp_model.pb.h"
#include "ortools/sat/cp_model_solver.h"
#include "ortools/util/sorted_interval_list.h"

namespace operations_research {
namespace sat {

void CpSatExample() {
  CpModelBuilder cp_model;

  int64_t var_upper_bound = std::max({50, 45, 37});
  const Domain domain(0, var_upper_bound);
  const IntVar x = cp_model.NewIntVar(domain).WithName("x");
  const IntVar y = cp_model.NewIntVar(domain).WithName("y");
  const IntVar z = cp_model.NewIntVar(domain).WithName("z");

  cp_model.AddLessOrEqual(2 * x + 7 * y + 3 * z, 50);
  cp_model.AddLessOrEqual(3 * x - 5 * y + 7 * z, 45);
  cp_model.AddLessOrEqual(5 * x + 2 * y - 6 * z, 37);

  cp_model.Maximize(2 * x + 2 * y + 3 * z);

  // Solving part.
  const CpSolverResponse response = Solve(cp_model.Build());

  if (response.status() == CpSolverStatus::OPTIMAL ||
      response.status() == CpSolverStatus::FEASIBLE) {
    // Get the value of x in the solution.
    LOG(INFO) << "Maximum of objective function: "
              << response.objective_value();
    LOG(INFO) << "x = " << SolutionIntegerValue(response, x);
    LOG(INFO) << "y = " << SolutionIntegerValue(response, y);
    LOG(INFO) << "z = " << SolutionIntegerValue(response, z);
  } else {
    LOG(INFO) << "No solution found.";
  }

  // Statistics.
  LOG(INFO) << "Statistics";
  LOG(INFO) << CpSolverResponseStats(response);
}

}  // namespace sat
}  // namespace operations_research

int main() {
  operations_research::sat::CpSatExample();
  return EXIT_SUCCESS;
}
