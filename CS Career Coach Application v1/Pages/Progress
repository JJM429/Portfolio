import React, { useState, useEffect } from "react";
import { base44 } from "@/api/base44Client";
import { User } from "@/entities/User";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Badge } from "@/components/ui/badge";
import { Progress } from "@/components/ui/progress";
import { Textarea } from "@/components/ui/textarea";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Target, Clock, BookOpen, TrendingUp, Edit, Save, X } from "lucide-react";
import { motion } from "framer-motion";

export default function ProgressPage() {
  const [modules, setModules] = useState([]);
  const [progress, setProgress] = useState([]);
  const [user, setUser] = useState(null);
  const [editingModule, setEditingModule] = useState(null);
  const [editData, setEditData] = useState({});
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    loadData();
  }, []);

  const loadData = async () => {
    try {
      const [modulesData, progressData, userData] = await Promise.all([
        base44.entities.Module.list("order_index"),
        base44.entities.StudentProgress.list(),
        User.me().catch(() => null)
      ]);
      setModules(modulesData);
      setProgress(progressData);
      setUser(userData);
    } catch (error) {
      console.error("Error loading data:", error);
    } finally {
      setIsLoading(false);
    }
  };

  const getModuleProgress = (moduleId) => {
    return progress.find(p => p.module_id === moduleId);
  };

  const handleEditProgress = (module) => {
    const moduleProgress = getModuleProgress(module.id);
    setEditingModule(module.id);
    setEditData({
      completion_percentage: moduleProgress?.completion_percentage || 0,
      notes: moduleProgress?.notes || '',
      current_focus: moduleProgress?.current_focus || '',
      time_spent_hours: moduleProgress?.time_spent_hours || 0,
      completed_topics: moduleProgress?.completed_topics || []
    });
  };

  const handleSaveProgress = async (moduleId) => {
    try {
      const existingProgress = getModuleProgress(moduleId);
      
      if (existingProgress) {
        await base44.entities.StudentProgress.update(existingProgress.id, {
          ...editData,
          module_id: moduleId
        });
      } else {
        await base44.entities.StudentProgress.create({
          ...editData,
          module_id: moduleId
        });
      }
      
      await loadData();
      setEditingModule(null);
    } catch (error) {
      console.error("Error saving progress:", error);
    }
  };

  const overallProgress = modules.length > 0 
    ? modules.reduce((sum, module) => {
        const prog = getModuleProgress(module.id);
        return sum + (prog?.completion_percentage || 0);
      }, 0) / modules.length 
    : 0;

  const totalHours = progress.reduce((sum, p) => sum + (p.time_spent_hours || 0), 0);
  const completedModules = progress.filter(p => p.completion_percentage === 100).length;

  return (
    <div className="min-h-screen bg-gradient-to-br from-slate-50 via-blue-50 to-emerald-50 p-4 md:p-8">
      <div className="max-w-6xl mx-auto">
        {/* Header */}
        <motion.div
          initial={{ opacity: 0, y: -20 }}
          animate={{ opacity: 1, y: 0 }}
          className="mb-8"
        >
          <h1 className="text-3xl md:text-4xl font-bold text-slate-900 mb-2">My Learning Progress</h1>
          <p className="text-slate-600">Track your journey through the Computer Science Coach program</p>
        </motion.div>

        {/* Stats Overview */}
        <motion.div
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ delay: 0.1 }}
          className="grid grid-cols-1 md:grid-cols-4 gap-6 mb-8"
        >
          <Card className="bg-gradient-to-br from-blue-500 to-blue-600 text-white border-0 shadow-xl">
            <CardContent className="p-6">
              <div className="flex items-center justify-between">
                <div>
                  <p className="text-blue-100 text-sm font-medium">Overall Progress</p>
                  <p className="text-3xl font-bold mt-1">{Math.round(overallProgress)}%</p>
                </div>
                <Target className="w-8 h-8 text-blue-200" />
              </div>
            </CardContent>
          </Card>

          <Card className="bg-gradient-to-br from-emerald-500 to-emerald-600 text-white border-0 shadow-xl">
            <CardContent className="p-6">
              <div className="flex items-center justify-between">
                <div>
                  <p className="text-emerald-100 text-sm font-medium">Completed</p>
                  <p className="text-3xl font-bold mt-1">{completedModules}/{modules.length}</p>
                </div>
                <BookOpen className="w-8 h-8 text-emerald-200" />
              </div>
            </CardContent>
          </Card>

          <Card className="bg-gradient-to-br from-amber-500 to-amber-600 text-white border-0 shadow-xl">
            <CardContent className="p-6">
              <div className="flex items-center justify-between">
                <div>
                  <p className="text-amber-100 text-sm font-medium">Hours Invested</p>
                  <p className="text-3xl font-bold mt-1">{totalHours}</p>
                </div>
                <Clock className="w-8 h-8 text-amber-200" />
              </div>
            </CardContent>
          </Card>

          <Card className="bg-gradient-to-br from-purple-500 to-purple-600 text-white border-0 shadow-xl">
            <CardContent className="p-6">
              <div className="flex items-center justify-between">
                <div>
                  <p className="text-purple-100 text-sm font-medium">Streak</p>
                  <p className="text-3xl font-bold mt-1">7 days</p>
                </div>
                <TrendingUp className="w-8 h-8 text-purple-200" />
              </div>
            </CardContent>
          </Card>
        </motion.div>

        {/* Module Progress */}
        <motion.div
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ delay: 0.2 }}
        >
          <h2 className="text-2xl font-bold text-slate-900 mb-6">Module Progress</h2>
          
          <div className="grid gap-6">
            {modules.map((module, index) => {
              const moduleProgress = getModuleProgress(module.id);
              const isEditing = editingModule === module.id;
              const progressPercentage = moduleProgress?.completion_percentage || 0;
              
              return (
                <motion.div
                  key={module.id}
                  initial={{ opacity: 0, x: -20 }}
                  animate={{ opacity: 1, x: 0 }}
                  transition={{ delay: index * 0.1 }}
                >
                  <Card className="bg-white/80 backdrop-blur-xl border-white/40 shadow-xl hover:shadow-2xl transition-all duration-300">
                    <CardHeader>
                      <div className="flex items-start justify-between">
                        <div className="flex-1">
                          <CardTitle className="text-xl text-slate-900 mb-2">{module.title}</CardTitle>
                          <p className="text-slate-600 mb-4">{module.description}</p>
                          
                          <div className="flex items-center gap-4 mb-4">
                            <Badge variant="outline" className="font-medium">
                              {module.difficulty_level}
                            </Badge>
                            <div className="flex items-center gap-1 text-sm text-slate-600">
                              <Clock className="w-4 h-4" />
                              <span>{module.duration_weeks} weeks</span>
                            </div>
                          </div>

                          <div className="flex items-center justify-between mb-2">
                            <span className="text-sm font-medium text-slate-600">Progress</span>
                            <span className="text-lg font-bold text-slate-900">{Math.round(progressPercentage)}%</span>
                          </div>
                          <Progress value={progressPercentage} className="h-3 mb-4" />
                        </div>
                        
                        <Button
                          variant="ghost"
                          size="icon"
                          onClick={() => isEditing ? setEditingModule(null) : handleEditProgress(module)}
                          className="hover:bg-blue-50"
                        >
                          {isEditing ? <X className="w-4 h-4" /> : <Edit className="w-4 h-4" />}
                        </Button>
                      </div>
                    </CardHeader>

                    <CardContent>
                      {isEditing ? (
                        <div className="space-y-6">
                          <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
                            <div>
                              <Label htmlFor="progress">Completion Percentage</Label>
                              <Input
                                id="progress"
                                type="number"
                                min="0"
                                max="100"
                                value={editData.completion_percentage}
                                onChange={(e) => setEditData({...editData, completion_percentage: parseInt(e.target.value)})}
                                className="mt-2"
                              />
                            </div>
                            <div>
                              <Label htmlFor="hours">Hours Spent</Label>
                              <Input
                                id="hours"
                                type="number"
                                min="0"
                                value={editData.time_spent_hours}
                                onChange={(e) => setEditData({...editData, time_spent_hours: parseInt(e.target.value)})}
                                className="mt-2"
                              />
                            </div>
                          </div>
                          
                          <div>
                            <Label htmlFor="focus">Current Focus</Label>
                            <Input
                              id="focus"
                              value={editData.current_focus}
                              onChange={(e) => setEditData({...editData, current_focus: e.target.value})}
                              placeholder="What are you currently working on?"
                              className="mt-2"
                            />
                          </div>

                          <div>
                            <Label htmlFor="notes">Notes & Reflections</Label>
                            <Textarea
                              id="notes"
                              value={editData.notes}
                              onChange={(e) => setEditData({...editData, notes: e.target.value})}
                              placeholder="Your thoughts, challenges, and achievements..."
                              className="mt-2 h-24"
                            />
                          </div>

                          <div className="flex justify-end gap-3">
                            <Button variant="outline" onClick={() => setEditingModule(null)}>
                              <X className="w-4 h-4 mr-2" />
                              Cancel
                            </Button>
                            <Button onClick={() => handleSaveProgress(module.id)} className="bg-blue-600 hover:bg-blue-700">
                              <Save className="w-4 h-4 mr-2" />
                              Save Progress
                            </Button>
                          </div>
                        </div>
                      ) : (
                        <div className="grid md:grid-cols-2 gap-6">
                          <div>
                            {moduleProgress?.current_focus && (
                              <div className="mb-4">
                                <h4 className="font-semibold text-slate-900 mb-2">Current Focus</h4>
                                <p className="text-slate-600 text-sm bg-slate-50 rounded-lg p-3">
                                  {moduleProgress.current_focus}
                                </p>
                              </div>
                            )}
                            
                            {moduleProgress?.time_spent_hours > 0 && (
                              <div>
                                <h4 className="font-semibold text-slate-900 mb-2">Time Invested</h4>
                                <div className="flex items-center gap-2">
                                  <Clock className="w-4 h-4 text-blue-600" />
                                  <span className="text-slate-600">{moduleProgress.time_spent_hours} hours</span>
                                </div>
                              </div>
                            )}
                          </div>
                          
                          {moduleProgress?.notes && (
                            <div>
                              <h4 className="font-semibold text-slate-900 mb-2">Notes</h4>
                              <p className="text-slate-600 text-sm bg-slate-50 rounded-lg p-3">
                                {moduleProgress.notes}
                              </p>
                            </div>
                          )}
                        </div>
                      )}
                    </CardContent>
                  </Card>
                </motion.div>
              );
            })}
          </div>
        </motion.div>
      </div>
    </div>
  );
}